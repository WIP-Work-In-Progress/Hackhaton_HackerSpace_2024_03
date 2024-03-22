"use client";
import React from "react";
import { useLoginContext, loginContext } from "../providers/loginContext";

function LoginProvider({ children }: { children: React.ReactNode }) {
  const [isLoggedIn, setIsLoggedIn] = React.useState(false);
  return (
    <loginContext.Provider value={{ isLoggedIn, setIsLoggedIn }}>
      {children}
    </loginContext.Provider>
  );
}

export default LoginProvider;
