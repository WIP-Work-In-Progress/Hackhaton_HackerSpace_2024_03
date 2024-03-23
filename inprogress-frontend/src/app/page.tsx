"use client";
import Link from "next/link";
import { db } from "../lib/mock_db";
import PersonInfoComponent from "./swiper/_components/person-info-component";
import { Button } from "@/components/ui/button";
export default function Home() {
  const fav = JSON.parse(sessionStorage.getItem("liked") || "[]");
  return (
    <div className="grid place-items-center p-4">
      <Link href="/swiper">
        <Button className="">Go to swiper</Button>
      </Link>
      <div className="grid grid-cols-2 gap-6 p-5">
        {db
          .filter((person) => fav.includes(person.id))
          .map((person) => (
            <div key={person.id}>
              <div className="swiper-person-card w-80 h-[30rem] bg-white  items-end flex rounded-[1rem] overflow-hidden">
                <img
                  src={`${person.url}`}
                  alt="profile-image"
                  className="h-[30rem] absolute"
                />
                <PersonInfoComponent
                  person={person}
                  fullInfo={false}
                  fontColor="text-white"
                ></PersonInfoComponent>
              </div>
            </div>
          ))}
      </div>
    </div>
  );
}
