import { Plugin } from "vite";

export default function requestLogger(): Plugin {
  return {
    name: "my-middleware-plugin",
    configureServer(server) {
      server.middlewares.use((req, res, next) => {
        console.log("Middleware triggered:", req.url);
        next();
      });
    },
  };
}
