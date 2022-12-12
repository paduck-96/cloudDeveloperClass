import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import App from "./App";

import { legacy_createStore as createStore, applyMiddleware } from "redux";
import { Provider } from "react-redux";
import rootReducer from "./modules";
import mymiddleware from "./middlewares/mymiddleware";
import logger from "redux-logger";

const store = createStore(rootReducer, applyMiddleware(mymiddleware, logger));

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <Provider store={store}>
    <App />
  </Provider>
);
