"use client";
import React from "react";
import { useLoginContext } from "../providers/loginContext";
import { Button } from "@/components/ui/button";

function Header() {
  const context = useLoginContext();
  const { isLoggedIn, setIsLoggedIn } = context;
  return (
    <header className="flex justify-between p-2 bg-primary">
      <div className="icon">InProgress</div>
      <div className="loginButtons">
        {isLoggedIn ? <Button>Logout</Button> : null}
      </div>
    </header>
  );
}

export default Header;
