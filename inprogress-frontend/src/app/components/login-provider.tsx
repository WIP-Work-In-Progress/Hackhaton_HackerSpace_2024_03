"use client";
import React from "react";
import { useLoginContext, loginContext } from "../providers/loginContext";

function LoginProvider({ children }: { children: React.ReactNode }) {
  const [isLoggedIn, setIsLoggedIn] = React.useState<boolean>(true);
  const [jwtToken, setJwtToken] = React.useState<string | null>(null);
  return (
    <loginContext.Provider
      value={{ isLoggedIn, setIsLoggedIn, jwtToken, setJwtToken }}
    >
      {children}
    </loginContext.Provider>
  );
}

export default LoginProvider;
