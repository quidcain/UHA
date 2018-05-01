import {Eptituder} from "./eptituder";

export class Event {
  id: number;
  name: string;
  ico: string;
  description: string;
  date: Date;
  points: number;
  status: string;
  rank: string;
  eptituders: Eptituder[];
}
