

public class Spreadsheet {
 
 // private fields
private Cell[][] sp;
private static int rows=11;
private static int cols=8;
private static int colWidth=12;  
private static int asciiOffSet=64;
private String border;
private String borderRow;
    
 // private methods
 private static int getCol(String location) {
  return (int)location.charAt(0)-asciiOffSet;
 }
 
 private static int getRow(String location) {
  return Integer.parseInt(location.substring(1));
 }
 
 private static String padOrTruncateDisplayString(Cell cell) {
     // truncate string to length - 1 and display >
     String s = cell.getDisplayString();
     if (s.length() > colWidth) {
       s = s.substring(0, colWidth - 1) + ">";
     }
     // if length is odd pad end to even length
     if (s.length() % 2 == 1) {
       s += " ";
     }
     // justify pad to center in cell
     while (s.length() < colWidth) {
       s = " " + s + " ";
     }
     return s;
 }
 
 // constructor
 public Spreadsheet() {
   border="";
   for(int i=0; i<colWidth; i++)
   {
     border+="-";
   }
   borderRow=border+"+";
   sp=new Cell[rows][cols];
  sp[0][0]=new CellString(" ");
  for (int col=1; col<cols;col++)
  {
    sp[0][col]=new CellString((asciiOffSet+col)+"");
    borderRow+=border+"+";
  }
    for (int row=1; row<rows; row++)
    {
    sp[row][0]=new CellString(row+"");
    for (int col=1; col<cols; col++)
    {
    sp[row][col]=new CellString("");
    }
 }
 }
 
 // mutators
 public void setCell(String location, Cell cell) {
  //TODO
   sp[getRow(location)][getCol(location)]=cell;
   
 }
 
 // accessors
 public Cell getCell(String location) {
  // TODO
   return sp[getRow(location)][getCol(location)];
 }
 
 public void print() {
  // TODO 
   System.out.print("             ");
   System.out.print("      A     |");
   System.out.print("      B     |");
   System.out.print("      C     |");
   System.out.print("      D     |");
   System.out.print("      E     |");
   System.out.print("      F     |");
   System.out.println("      G     |");
   for(int row=1; row<rows; row++)
   {
     for(int col=1; col<cols; col++)
     {
       System.out.println(padOrTruncateDisplayString(sp[row][col]));
       System.out.println(borderRow);
     }
   }
   
 }
}



    
