import { Plugin } from "vite";

export default function requestLogger(): Plugin {
  return {
    name: "request-logger",
    configureServer(server) {
      server.middlewares.use((req, res, next) => {
        console.log("Middleware triggered:", req.url);
        next();
      });
    },
  };
}
