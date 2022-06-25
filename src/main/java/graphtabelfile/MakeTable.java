package graphtabelfile;

import javax.swing.JTable;

public class MakeTable {
    public MyJTable getTable(double xMin, double xMax, int n){
        Double[][] cells;
        String[] colNames = new String[]{" X ", " Y "};
        int k = 2;
        double x, dx = (xMax - xMin) / (n - 1);
        cells = new Double[n][k];
        for (int i = 0; i < n; i++){
            x = xMin + dx * i;
            cells[i][0] = x;
            cells[i][1] = MyFunc.getMyFunc(x);
        }
        return new MyJTable(cells, colNames);
    }
    class MyJTable extends JTable{

        public MyJTable(final Object[][] rowData, final Object[] columnNames) {
            super(rowData, columnNames);
        }
        @Override
        public boolean isCellEditable(int i, int i1){
            return false;
        }
    }
}
