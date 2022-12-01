const express = require("express");
const multer = require("multer"); //파일 업로드
const path = require("path");
const fs = require("fs");
const { Post, Hashtag } = require("../models"); //데이터 삽입 모듈
// DB 연결
//로그인 여부 판단 모듈
const { isLoggedIn } = require("./middlewares");

const router = express.Router();

// 파일 업로드 디렉토리 확인
try {
  fs.readdirSync("public/img");
} catch (err) {
  fs.mkdirSync("public/img");
}

// 파일 업로드 객체 생성
const upload = multer({
  storage: multer.diskStorage({
    destination(req, file, cb) {
      cb(null, "public/img");
    },
    filename(req, file, cb) {
      const ext = path.extname(file.originalname);
      cb(null, path.basename(file.originalname, ext) + Date.now() + ext);
    },
  }),
  limits: { fileSize: 10 * 1024 * 1024 },
});

router.post("/img", isLoggedIn, upload.single("img"), (req, res) => {
  console.log(req.file);
  res.json({
    url: `/img/${req.file.filename}`,
  });
});

// 게시글 업로드 객체
// 따로 구분
const upload2 = multer();
router.post("/", isLoggedIn, upload2.none(), async (req, res, next) => {
  // DB 연동 작업은 무조건 비동기 처리
  try {
    const post = await Post.create({
      content: req.body.content,
      img: req.body.url,
      UserId: req.user.id,
    });
    // 해시태그 찾기
    const hashtags = req.body.content.match(/#[^\s#]*/g);
    // 해시태그 있으면 삽입
    if (hashtags) {
      // 전부 실행
      const result = await Promise.all(
        hashtags.map((tag) => {
          return Hashtag.findOrCreate({
            where: { title: tag.slice(1).toLowerCase() },
          });
        })
      );
      await post.addHashtags(result.map((r) => r[0]));
    }
    res.redirect("/");
  } catch (err) {
    console.error(err);
    next(err);
  }
});

module.exports = router;
