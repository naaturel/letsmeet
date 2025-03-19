/**
 * I hate JavaScript and TypeScript with every single inch of my body
 */
export class CustomMap<K, V> extends Map<K, V> {
  has(obj: K): boolean {
    return false;
  }
}
