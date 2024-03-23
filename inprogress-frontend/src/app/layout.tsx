import type { Metadata } from "next";
import { Inter } from "next/font/google";
import "./globals.css";
import Header from "./components/header";
import LoginProvider from "./components/login-provider";

const inter = Inter({ subsets: ["latin"] });

export const metadata: Metadata = {
  title: "InProgress",
  description: "Find you mentor here!",
};

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="pl">
      <body className={inter.className}>
        <LoginProvider>
          <Header />
          {children}
        </LoginProvider>
      </body>
    </html>
  );
}
