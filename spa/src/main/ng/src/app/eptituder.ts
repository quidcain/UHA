import {Clan} from "./clan";
import {Event} from "./event";

export class Eptituder {
  id: number;
  name: string;
  side: string;
  eptitudes: string;
  ico: string;
  bio: string;
  rank: string;
  points: string;
  clans: Clan[];
  events: Event[];
}
