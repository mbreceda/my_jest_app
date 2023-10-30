import { useState } from "react";
import reactLogo from "./assets/react.svg";
import viteLogo from "/vite.svg";
import "./App.css";

import LoginForm from "./LoginForm";

function App() {
  const [count, setCount] = useState(0);

  return (
    <>
      <LoginForm
        shouldRemember={true}
        onUsernameChange={() => console.log("onUsernameChange")}
        onPasswordChange={() => console.log("onPasswordChange")}
        onRememberChange={() => console.log("onRememberChange")}
        onSubmit={() => console.log("onSubmit")}
      />
    </>
  );
}

export default App;
