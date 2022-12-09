import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import App from "./App";
import { BrowserRouter } from "react-router-dom";
//import "./exercise";

import rootReducer from "./modules";
import { createStore } from "redux";
import { Provider } from "react-redux";

const store = createStore(rootReducer);
//console.log(store.getState());

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  //<BrowserRouter>
  <Provider store={store}>
    <App />
  </Provider>
  //</BrowserRouter>
);
