const express = require("express");
const path = require("path");

const router = express.Router();

router.get("/", (req, res) => {
  res.send("hello board!");
});
module.exports = router;
