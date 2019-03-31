import java.util.*;

public class TreePrinter<T extends Comparable<T>> {

    public static String getTreeDisplay(AVLNode root) {

        StringBuilder sb         = new StringBuilder();
        List<List<String>> lines = new ArrayList<>();
        List<AVLNode> level      = new ArrayList<>();
        List<AVLNode> next       = new ArrayList<>();

        level.add(root);
        int nn = 1;
        int widest = 0;

        while (nn != 0) {
            nn = 0;
            List<String> line = new ArrayList<String>();
            for (AVLNode n : level) {
                if (n == null) {
                    line.add(null);
                    next.add(null);
                    next.add(null);
                } else {
                    String aa = n.dato.toString();
                    line.add(aa);
                    if (aa.length() > widest) widest = aa.length();

                    next.add(n.izquierdo);
                    next.add(n.derecho);

                    if (n.izquierdo != null) nn++;
                    if (n.derecho != null) nn++;
                }
            }

            if (widest % 2 == 1) widest++;

            lines.add(line);

            List<AVLNode> tmp = level;
            level = next;
            next = tmp;
            next.clear();
        }

        int perpiece = lines.get(lines.size() - 1).size() * (widest + 4);
        for (int i = 0; i < lines.size(); i++) {
            List<String> line = lines.get(i);
            int hpw = (int) Math.floor(perpiece / 2f) - 1;
            if (i > 0) {
                for (int j = 0; j < line.size(); j++) {

                    // split node
                    char c = ' ';
                    if (j % 2 == 1) {
                        if (line.get(j - 1) != null) {
                            c = (line.get(j) != null) ? '-' : '-';
                        } else {
                            if (j < line.size() && line.get(j) != null) c = '-';
                        }
                    }
                    sb.append(c);

                    // lines and spaces
                    if (line.get(j) == null) {
                        for (int k = 0; k < perpiece - 1; k++) {
                            sb.append(' ');
                        }
                    } else {
                        for (int k = 0; k < hpw; k++) {
                            sb.append(j % 2 == 0 ? " " : "-");
                        }
                        sb.append(j % 2 == 0 ? "|" : "|");
                        for (int k = 0; k < hpw; k++) {
                            sb.append(j % 2 == 0 ? "-" : " ");
                        }
                    }
                }
                sb.append('\n');
            }
            for (int j = 0; j < line.size(); j++) {
                String f = line.get(j);
                if (f == null) f = "";
                int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f);
                int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f);

                for (int k = 0; k < gap1; k++) {
                    sb.append(' ');
                }
                sb.append(f);
                for (int k = 0; k < gap2; k++) {
                    sb.append(' ');
                }
            }
            sb.append('\n');

            perpiece /= 2;
        }
        return sb.toString();
    }
}
