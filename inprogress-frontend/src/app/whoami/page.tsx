import { Separator } from "@/components/ui/separator";
import React from "react";
import PreferencesForm from "./_components/preferences-form";
import MentorInfo from "./_components/mentor-info";

export default function page() {
  return (
    <div className="bg-secondary py-6">
      <h2 className="text-xl px-10">Preferencje</h2>
      <Separator className="bg-black w-full" />
      <div className="mentor px-10">
        <MentorInfo />
      </div>
    </div>
  );
}
