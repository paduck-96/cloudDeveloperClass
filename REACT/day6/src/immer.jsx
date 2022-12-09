import { useCallback, useRef, useState } from "react";
import produce from "immer";

const Immer = () => {
  // 컴포넌트 안에서 사용할 변수 생성
  const nextId = useRef(1);
  const [form, setForm] = useState({ name: "", username: "" });
  const [data, setData] = useState({
    array: [],
    uselessValue: null,
  });

  // input 입력 시 state 수정
  const onChange = useCallback((e) => {
    const { name, value } = e.target;
    setForm(
      // spread 연산자 처리 불필요
      //draft 자체게 주어지는 state 의 복제본
      produce((draft) => {
        draft[name] = value;
      })
    );
  }, []);

  // 입력받은 데이터 등록
  // 컴포넌트 속 함수는 useCallback 권장
  //deps 변경에 따른 재생성만 허용
  const onSubmit = useCallback(
    (e) => {
      e.preventDefault();
      const info = {
        id: nextId.current,
        name: form.name,
        username: form.username,
      };

      // setData({
      //   ...data,
      //   array: data.array.concat(info),
      // });

      setData(
        produce((draft) => {
          draft.array.push(info);
        })
      );

      setForm({
        name: "",
        username: "",
      });
      nextId.current += 1;
    },
    [form.name, form.username]
  );

  // 항목 삭제
  const onRemove = useCallback((e) => {
    // setData({
    //   ...data,
    //   array: data.array.filter((info) => info.id !== id),
    // });
    setData(
      produce((draft) => {
        draft.array.splice(
          draft.array.findIndex((info) => info.id === e),
          1
        );
      })
    );
  }, []);

  return (
    <div className="Immer">
      <form onSubmit={onSubmit}>
        <input
          name="username"
          placeholder="아이디 입력"
          value={form.username}
          onChange={onChange}
        />
        <input
          name="name"
          placeholder="이름 입력"
          value={form.name}
          onChange={onChange}
        />
        <button type="submit">등록</button>
      </form>

      <div>
        <ul>
          {data.array.map((info) => {
            <li key={info.id} onClick={() => onRemove(info.id)}>
              {info.username} ({info.name})
            </li>;
          })}
        </ul>
      </div>
    </div>
  );
};

export default Immer;
