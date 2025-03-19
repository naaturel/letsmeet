import {API_PATHS} from "@/config/ApiConfig.ts";
import {EventDto} from "@/dto/EventDto.ts";

export class EventRequests {

  private readonly baseUrl: string;
  private readonly endpoints;

  public constructor() {
    this.baseUrl = API_PATHS.BASE_URL;
    this.endpoints = API_PATHS.ENDPOINTS;
  }

  private formatUrl(parts:string[]) : string {
    let res = "";
    parts.forEach((value) => {
      res += value.trim();
    })
    return res.replace(/([^:]\/)\/+/g, "$1");
  }

  public async queryEvent(token : string): Promise<void | EventDto>  {

    let url = this.formatUrl([this.baseUrl, this.endpoints.EVENTS, token]);
    return fetch(url)
      .then(response => response.json())
      .then(data => new EventDto(data.name, data.token, data.participants))
      .catch(error => console.error(error));
  }
}
