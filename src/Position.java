/**
 * C言語のTypeの代わりに使用するクラス 
 *
 * 座標を表す場合や、辺を表す場合に使用する。
 * 
 * 
 */
public class Position {

    int x = 0;
    int y = 0;
    
    Position(int a, int b) {
        this.x = a;
        this.y = b;

    }
    int getSum() {
        return x + y;
    }
    
    @Override
    public int hashCode() {
        return x * 1000000 + y;
    }
    
    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Position)) {
            return false;
        }
        
        Position pos = (Position) obj;
        if (pos.x == x && pos.y == y) {
            return true;
        }
        return false;
    }
}
