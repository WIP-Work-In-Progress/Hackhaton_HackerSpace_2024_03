interface ILoginContext {
  isLoggedIn: boolean;
  setIsLoggedIn: (isLoggedIn: boolean) => void;
  jwtToken: string | null;
  setJwtToken: (jwtToken: string) => void;
}
export default ILoginContext;
