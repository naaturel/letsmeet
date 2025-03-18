import { API_PATHS } from "@/config/ApiConfig.ts";

export class EventRequests {

  private readonly baseUrl: string;
  private readonly endpoints;

  public constructor() {
    this.baseUrl = API_PATHS.BASE_URL;
    this.endpoints = API_PATHS.ENDPOINTS;
  }

  private formatUrl(parts:string[]) : string {
    let res = "";
    console.log(parts)
    parts.forEach((value) => {
      console.log(value)
      res += value.trim();
    })
    return res.replace(/(http|https?:\/\/[^\/]+)\/\//, '$1/');
  }

  public queryEvent(token : string) {

    let url = this.formatUrl([this.baseUrl, this.endpoints.EVENTS, token]);
    console.log(url);
    fetch(url)
      .then(response => response.json())
      .then(data => console.log(data))
      .catch(error => console.error(error));

  }
}
