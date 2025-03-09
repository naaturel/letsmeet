export abstract class ArrayHelper {

  public static contains(array : any[], element : any) : boolean {
    return array.indexOf(element) > -1;
  }

  public static indexOf(array : any[], element : any) : number {
    return array.indexOf(element);
  }

  public static toggleElement(array : any[], element : any) : void {

    let index = ArrayHelper.indexOf(array, element);
    console.log(index);
    if(index < 0) {
      console.log("Not in array")
      array.push(element);
    } else {
      console.log("Already in array")
      array.splice(index, 1);
    }
  }

}
