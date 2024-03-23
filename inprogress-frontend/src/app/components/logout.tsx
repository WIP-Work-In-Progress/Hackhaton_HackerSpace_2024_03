"use client";
import { deleteCookie } from "cookies-next";
import React from "react";
import { useLoginContext } from "../providers/loginContext";

function Logout() {
  const logout = () => {
    deleteCookie("token");
    const { setIsLoggedIn } = useLoginContext();
    setIsLoggedIn(false);
  };
  return <div>Logout</div>;
}

export default Logout;
