import { createContext, useContext } from "react";
import ILoginContext from "../models/ILoginContext";

export const loginContext = createContext<ILoginContext | null>(null);
export const useLoginContext = () => {
  const context = useContext(loginContext);
  if (context === null) {
    throw new Error("useLoginContext must be used within a LoginProvider");
  }
  return context;
};
