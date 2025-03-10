export abstract class ArrayHelper {

  public static contains(array : any[], element : any) : boolean {
    return array.indexOf(element) > -1;
  }

  public static indexOf(array : any[], element : any) : number {
    return array.indexOf(element);
  }
}
