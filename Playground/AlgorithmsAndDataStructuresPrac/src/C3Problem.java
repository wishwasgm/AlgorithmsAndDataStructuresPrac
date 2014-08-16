//Print a nxn spiral matrix in counter clockwise direction
//
//Input:
//1  2  3  4
//5  6  7  8
//9  10 11 12
//13 14 15 16
//
//Outputs:
//1 5 9 13 14 15 16 12 8 4 3 2 6 10 11 7
//
//int TRAVERSED = -100;
//
//main method:
//traverse (a);	
//
//get input n
//
//traverse (int[][] a) {
//
// int widthInput = a[0].length;
// int depthInput = a.length;
// 
// if ( a[widthInput][depthInput] != TRAVERSED) {
//     //Sysout(a[widthInput][depthInput]);
//     a[widthInput][depthInput] = TRAVERSED;
//     return;
// }
// 
// //Traversing down
// for (int x=0; x < height - 1; x++) {
//   // print elements out
//  sysout (a[x][0]);
// }
// 
// for (int y=0; y<width - 1; y++) {
// sysout(a[height][y]);
//}
//
//for (int m = height - 1; y > 0; m--) {
// sysout(a[m][width]);
//}
//
//for (int n = width - 2; n >= 0; n--) {
// sysout(a[0][n]);
//}
//
//int[][] innerMatrix = new int[widthInput-2][depthInput-2];
//for int(i=0;i<widthInput-1;i++) {
//    for int(j=0;j<depthInput-1;j++){
//        innerMatrix[i][j] = a [i+1][j+1];
//    }
//}
//
//if (innerMatrix.length > 0) {
//  traverse(innerMatrix);
//}
//
//}