"use client";
import React from "react";
import { useLoginContext } from "../providers/loginContext";
import { Button } from "@/components/ui/button";
import Link from "next/link";
import { useRouter } from "next/navigation";

function Header() {
  const context = useLoginContext();
  const { isLoggedIn, setIsLoggedIn } = context;
  const router = useRouter();

  function logOut() {
    setIsLoggedIn(false);
    router.push("/auth");
  }

  return (
    <header className="flex justify-between p-2 bg-primary items-center">
      <div className="icon">InProgress</div>
      {isLoggedIn ? (
        <div className="flex gap-2">
          <Link href={"/swiper"}>
            <Button type="button">Szukaj</Button>
          </Link>
          <Button variant={"secondary"} type="button" onClick={logOut}>
            Wyloguj
          </Button>
        </div>
      ) : null}
    </header>
  );
}

export default Header;
