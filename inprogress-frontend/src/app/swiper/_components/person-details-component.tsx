import { ArrowUp } from "lucide-react";
import PersonInfoComponent from "./person-info-component";

export default function PersonDetailsComponent({ person, goBack }: { personId: string, goBack: any }) {
  
  return <div className="z-100 absolute w-80 h-[30rem] bg-white flex flex-col rounded-[1rem] "><div className="w-[fit-content] mx-auto h-[1.5rem] pt-2 pb-8"><button onClick={() => goBack()} className="m-auto"><ArrowUp className="text-black"/></button></div><div><PersonInfoComponent person={person} fullInfo={true} fontColor={"text-black"}></PersonInfoComponent></div></div>
}