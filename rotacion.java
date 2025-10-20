
public class rotacion {
    // constantes
    static final int w = 60;
    static final int h = 22;
    static final int s = 8;
    static final char c = '#';
    static final char linea = '*';

    // tablas de desplazamiento (animación)
    static final int offX[] = {-6,-4,-2,0,2,4,6,4,2,0,-2,-4};
    static final int offY[] = { 0, 2, 4, 6, 4, 2, 0,-2,-4,-6,-4,-2};

    public static void main(String[] args) throws InterruptedException {
        // buffer de pantalla
        char[][] buf = new char[h][w];

        while (true) {
            for (int k = 0; k < offX.length; k++) {
                // 1) limpiar buffer con espacios
                for (int y = 0; y < h; y++) {
                    for (int x = 0; x < w; x++) {
                        buf[y][x] = ' ';
                    }
                }

                // 2) centro y posiciones de las dos caras del cubo
                int cx = w / 2;
                int cy = h / 2;

                int bx = cx - 10 + offX[k];      // back face (izq)
                int by = cy - 4  + offY[k];
                int fx = cx + offX[k];           // front face (der)
                int fy = cy - 4  - offY[k];

                // 3) dibujar las dos caras 
                drawCube(buf, bx, by, s, s, c);
                drawCube(buf, fx, fy, s, s, c);
                // 4) conectar las esquinas
                connect(buf, bx,       by,       fx,       fy,       linea);
                connect(buf, bx + s-1, by,       fx + s-1, fy,       linea);
                connect(buf, bx,       by + s-1, fx,       fy + s-1, linea);
                connect(buf, bx + s-1, by + s-1, fx + s-1, fy + s-1, linea);

             
                printBuf(buf);
                Thread.sleep(90);
            }
        }
    }

    // Dibuja el contorno de un cuadrado
    static void drawCube(char[][] buf, int x, int y, int ancho, int alto, char ch) {
        // bordes verticales
        for (int i = 0; i < alto; i++) {
            p(buf, x,         y + i, ch);
            p(buf, x + ancho - 1, y + i, ch);
        }
        // bordes horizontales
        for (int j = 0; j < ancho; j++) {
            p(buf, x + j, y,          ch);
            p(buf, x + j, y + alto - 1, ch);
        }
    }

    // Dibuja una línea simple entre (x1,y1) y (x2,y2)
    static void connect(char[][] buf, int x1, int y1, int x2, int y2, char ch) {
        int dx = x2 - x1;
        int dy = y2 - y1;
        int steps = Math.max(Math.abs(dx), Math.abs(dy));
        float xInc = dx / (float) steps;
        float yInc = dy / (float) steps;
        float x = x1;
        float y = y1;
        for (int i = 0; i <= steps; i++) {
            p(buf, Math.round(x), Math.round(y), ch);
            x += xInc;
            y += yInc;
        }
    }

    // Imprime el buffer en consola
    static void printBuf(char[][] buf) {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                sb.append(buf[y][x]);
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }

    // Pone un carácter si (x,y) está dentro del “lienzo”
    static void p(char[][] buf, int x, int y, char ch) {
        if (x >= 0 && x < w && y >= 0 && y < h) {
            buf[y][x] = ch;
        }
    }
}
