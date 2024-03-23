"use client";
import { Settings, User } from "lucide-react";

import SwiperComponent from "./_components/swiper-component";
import Link from "next/link";

export default function Swiper() {
  return (
    <>
      <ul className="flex gap-1 justify-end px-2 py-2">
        <li className="p-2 rounded-full bg-gray-800 text-white">
          <Link href="/whoami">
            <Settings />
          </Link>
        </li>
        <li className="p-2 rounded-full bg-gray-800 text-white">
          <Link href="/preferences">
            <User />
          </Link>
        </li>
      </ul>
      <SwiperComponent />
    </>
  );
}
