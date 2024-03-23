import { MetadataRoute } from "next";

export default function manifest(): MetadataRoute.Manifest {
  return {
    name: "InProgress",
    short_name: "InP",
    description: "Find your dream mentor here",
    start_url: "/",
    display: "standalone",
    background_color: "#000",
    theme_color: "#fff",
    icons: [
      {
        src: "/images/wip-logo-512.png",
        type: "image/png",
        sizes: "512x512",
      },
      {
        src: "/images/wip-logo-256.png",
        type: "image/png",
        sizes: "256x256",
      },
      {
        src: "/images/wip-logo-128.png",
        type: "image/png",
        sizes: "128x128",
      },
    ],
  };
}
