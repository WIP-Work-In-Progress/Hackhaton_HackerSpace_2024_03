import { Separator } from "@/components/ui/separator";
import React from "react";
import PreferencesForm from "./_components/preferences-form";
import MentorInfo from "./_components/mentor-info";

export default function page() {
  return (
    <div className="px-10">
      <h2>Preferencje</h2>
      <Separator />
      <MentorInfo />
    </div>
  );
}
