import { ArrowUp } from "lucide-react";

export default function PersonDetailsComponent({ personId, goBack }: { personId: string, goBack: any }) {
  
  return <div className="z-100 absolute w-80 h-[30rem] bg-white flex flex-col"><div className="w-[fit-content] mx-auto"><button onClick={() => goBack()} className="m-auto"><ArrowUp /></button></div><div>Test</div></div>
}