/* The following code was generated by JFlex 1.6.1 */


import java_cup.runtime.*;



/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.6.1
 * from the specification file <tt>D:/projComp/src/scanner.flex</tt>
 */
class Yylex implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int STRING = 2;
  public static final int CHAR = 4;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2, 2
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\3\1\2\1\71\1\71\1\1\22\0\1\3\1\41\1\66"+
    "\1\65\1\0\1\53\1\45\1\67\1\56\1\57\1\50\1\51\1\63"+
    "\1\10\1\11\1\52\1\6\11\5\1\62\1\37\1\42\1\40\1\43"+
    "\2\0\4\4\1\13\25\4\1\60\1\70\1\61\1\47\1\4\1\0"+
    "\1\23\1\14\1\25\1\32\1\12\1\33\1\15\1\27\1\16\1\4"+
    "\1\24\1\21\1\4\1\17\1\20\1\34\1\4\1\22\1\26\1\30"+
    "\1\31\1\64\1\36\1\7\1\4\1\35\1\54\1\46\1\55\1\44"+
    "\6\0\1\71\u1fa2\0\1\71\1\71\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\udfe6\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\3\0\1\1\1\2\1\3\2\4\1\5\1\1\17\3"+
    "\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15"+
    "\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25"+
    "\1\26\1\27\1\30\1\31\1\32\1\3\1\1\1\33"+
    "\1\34\1\35\1\2\2\35\1\36\2\1\1\2\3\1"+
    "\1\37\2\0\1\40\1\0\1\41\7\3\1\42\1\43"+
    "\1\3\1\44\1\3\1\45\22\3\1\46\1\47\1\50"+
    "\1\51\1\52\1\53\1\54\1\55\1\0\1\3\1\56"+
    "\1\35\1\57\1\60\2\0\1\4\1\3\1\61\5\3"+
    "\1\62\1\3\1\63\5\3\1\64\14\3\1\65\3\3"+
    "\1\0\1\3\1\0\1\35\1\37\1\0\1\3\1\66"+
    "\1\3\1\67\1\3\1\70\2\3\1\71\3\3\1\72"+
    "\2\3\1\73\1\74\4\3\1\75\6\3\1\56\1\76"+
    "\1\56\1\3\1\77\1\100\1\101\4\3\1\102\5\3"+
    "\1\103\3\3\1\104\1\3\1\105\1\106\1\107\1\110"+
    "\1\111\1\3\1\112\1\113\1\114\1\115\1\3\1\116"+
    "\3\3\1\117\1\120\1\3\1\121\1\122";

  private static int [] zzUnpackAction() {
    int [] result = new int[224];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\72\0\164\0\256\0\256\0\350\0\u0122\0\u015c"+
    "\0\u0196\0\u01d0\0\u020a\0\u0244\0\u027e\0\u02b8\0\u02f2\0\u032c"+
    "\0\u0366\0\u03a0\0\u03da\0\u0414\0\u044e\0\u0488\0\u04c2\0\u04fc"+
    "\0\u0536\0\256\0\u0570\0\u05aa\0\u05e4\0\u061e\0\256\0\256"+
    "\0\256\0\256\0\u0658\0\u0692\0\u06cc\0\256\0\256\0\256"+
    "\0\256\0\256\0\256\0\256\0\256\0\256\0\u0706\0\u0740"+
    "\0\256\0\256\0\u077a\0\u077a\0\u07b4\0\u07ee\0\256\0\u0828"+
    "\0\u0862\0\u0862\0\u089c\0\u08d6\0\u0910\0\u094a\0\u0984\0\u09be"+
    "\0\256\0\u01d0\0\256\0\u09f8\0\u0a32\0\u0a6c\0\u0aa6\0\u0ae0"+
    "\0\u0b1a\0\u0b54\0\u0b8e\0\350\0\u0bc8\0\350\0\u0c02\0\350"+
    "\0\u0c3c\0\u0c76\0\u0cb0\0\u0cea\0\u0d24\0\u0d5e\0\u0d98\0\u0dd2"+
    "\0\u0e0c\0\u0e46\0\u0e80\0\u0eba\0\u0ef4\0\u0f2e\0\u0f68\0\u0fa2"+
    "\0\u0fdc\0\u1016\0\256\0\256\0\256\0\256\0\256\0\256"+
    "\0\256\0\256\0\u1050\0\u108a\0\u10c4\0\u10fe\0\256\0\256"+
    "\0\u0862\0\u1138\0\u09be\0\u1172\0\350\0\u11ac\0\u11e6\0\u1220"+
    "\0\u125a\0\u1294\0\350\0\u12ce\0\350\0\u1308\0\u1342\0\u137c"+
    "\0\u13b6\0\u13f0\0\350\0\u142a\0\u1464\0\u149e\0\u14d8\0\u1512"+
    "\0\u154c\0\u1586\0\u15c0\0\u15fa\0\u1634\0\u166e\0\u16a8\0\u16e2"+
    "\0\u171c\0\u1756\0\u1790\0\u17ca\0\u1804\0\u183e\0\u1878\0\u18b2"+
    "\0\u18b2\0\u18ec\0\350\0\u1926\0\350\0\u1960\0\350\0\u199a"+
    "\0\u19d4\0\350\0\u1a0e\0\u1a48\0\u1a82\0\350\0\u1abc\0\u1af6"+
    "\0\350\0\350\0\u1b30\0\u1b6a\0\u1ba4\0\u1bde\0\350\0\u1c18"+
    "\0\u1c52\0\u1c8c\0\u1cc6\0\u1d00\0\u1d3a\0\256\0\350\0\u077a"+
    "\0\u1d74\0\350\0\350\0\350\0\u1dae\0\u1de8\0\u1e22\0\u1e5c"+
    "\0\350\0\u1e96\0\u1ed0\0\u1f0a\0\u1f44\0\u1f7e\0\350\0\u1fb8"+
    "\0\u1ff2\0\u202c\0\350\0\u2066\0\350\0\350\0\350\0\350"+
    "\0\350\0\u20a0\0\350\0\350\0\350\0\350\0\u20da\0\350"+
    "\0\u2114\0\u214e\0\u2188\0\350\0\350\0\u21c2\0\350\0\350";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[224];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\4\3\5\1\6\1\7\1\10\1\6\1\11\1\12"+
    "\1\13\1\6\1\14\1\15\1\16\1\17\1\20\1\21"+
    "\1\22\1\23\1\6\1\24\1\25\1\6\1\26\1\27"+
    "\1\30\1\31\3\6\1\32\1\33\1\34\1\35\1\36"+
    "\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46"+
    "\1\47\1\50\1\51\1\52\1\53\1\54\1\55\1\56"+
    "\1\57\1\60\1\61\1\62\2\4\1\63\2\5\1\64"+
    "\46\63\1\65\12\63\1\66\1\67\1\63\1\70\1\63"+
    "\1\71\2\5\1\72\46\71\1\73\12\71\1\74\1\71"+
    "\1\4\1\75\1\71\76\0\4\6\2\0\25\6\25\0"+
    "\1\6\12\0\2\7\2\0\1\76\65\0\2\77\1\100"+
    "\1\0\1\76\65\0\1\7\1\10\1\0\1\101\1\102"+
    "\26\0\1\103\36\0\2\76\67\0\3\6\1\104\2\0"+
    "\5\6\1\105\1\6\1\106\15\6\25\0\1\6\11\0"+
    "\4\6\2\0\1\107\5\6\1\110\1\6\1\111\14\6"+
    "\25\0\1\6\11\0\4\6\2\0\6\6\1\112\16\6"+
    "\25\0\1\6\11\0\4\6\2\0\5\6\1\113\13\6"+
    "\1\114\3\6\25\0\1\6\11\0\4\6\2\0\6\6"+
    "\1\115\16\6\25\0\1\6\11\0\4\6\2\0\10\6"+
    "\1\116\6\6\1\117\1\6\1\120\3\6\25\0\1\6"+
    "\11\0\4\6\2\0\6\6\1\121\16\6\25\0\1\6"+
    "\11\0\4\6\2\0\1\122\24\6\25\0\1\6\11\0"+
    "\4\6\2\0\5\6\1\123\11\6\1\124\5\6\25\0"+
    "\1\6\11\0\4\6\2\0\6\6\1\125\2\6\1\126"+
    "\3\6\1\127\7\6\25\0\1\6\11\0\4\6\2\0"+
    "\4\6\1\130\11\6\1\131\5\6\1\132\25\0\1\6"+
    "\11\0\4\6\2\0\10\6\1\133\14\6\25\0\1\6"+
    "\11\0\4\6\2\0\5\6\1\134\17\6\25\0\1\6"+
    "\11\0\4\6\2\0\1\135\5\6\1\136\16\6\25\0"+
    "\1\6\11\0\4\6\2\0\6\6\1\137\1\140\1\6"+
    "\1\141\5\6\1\142\5\6\25\0\1\6\45\0\1\143"+
    "\71\0\1\144\71\0\1\145\71\0\1\146\71\0\1\147"+
    "\36\0\1\7\1\10\2\0\1\102\26\0\1\150\10\0"+
    "\1\151\60\0\1\152\24\0\1\153\10\0\4\6\2\0"+
    "\6\6\1\154\16\6\25\0\1\6\72\0\1\155\4\0"+
    "\1\63\2\0\63\63\1\0\1\63\1\0\2\63\2\0"+
    "\62\63\1\156\1\0\1\63\1\0\2\63\2\0\62\63"+
    "\1\155\1\0\1\63\1\0\1\63\1\157\2\0\66\157"+
    "\70\0\1\160\67\0\1\153\1\0\1\160\67\0\1\155"+
    "\1\0\1\160\2\0\1\161\2\0\66\161\6\0\2\76"+
    "\3\0\2\162\63\0\2\77\2\0\1\76\65\0\2\163"+
    "\67\0\4\6\2\0\16\6\1\164\6\6\25\0\1\6"+
    "\11\0\4\6\2\0\20\6\1\165\4\6\25\0\1\6"+
    "\11\0\4\6\2\0\14\6\1\166\10\6\25\0\1\6"+
    "\11\0\4\6\2\0\3\6\1\167\21\6\25\0\1\6"+
    "\11\0\4\6\2\0\6\6\1\170\16\6\25\0\1\6"+
    "\11\0\4\6\2\0\1\171\24\6\25\0\1\6\11\0"+
    "\4\6\2\0\16\6\1\172\6\6\25\0\1\6\11\0"+
    "\4\6\2\0\16\6\1\173\3\6\1\174\2\6\25\0"+
    "\1\6\11\0\4\6\2\0\16\6\1\175\6\6\25\0"+
    "\1\6\11\0\4\6\2\0\16\6\1\176\6\6\25\0"+
    "\1\6\11\0\4\6\2\0\5\6\1\177\17\6\25\0"+
    "\1\6\11\0\4\6\2\0\13\6\1\200\2\6\1\201"+
    "\3\6\1\202\2\6\25\0\1\6\11\0\4\6\2\0"+
    "\20\6\1\203\4\6\25\0\1\6\11\0\4\6\2\0"+
    "\16\6\1\204\6\6\25\0\1\6\11\0\4\6\2\0"+
    "\5\6\1\205\17\6\25\0\1\6\11\0\4\6\2\0"+
    "\14\6\1\206\10\6\25\0\1\6\11\0\4\6\2\0"+
    "\11\6\1\207\13\6\25\0\1\6\11\0\4\6\2\0"+
    "\23\6\1\210\1\6\25\0\1\6\11\0\4\6\2\0"+
    "\10\6\1\211\1\212\13\6\25\0\1\6\11\0\4\6"+
    "\2\0\4\6\1\213\20\6\25\0\1\6\11\0\4\6"+
    "\2\0\17\6\1\214\5\6\25\0\1\6\11\0\4\6"+
    "\2\0\16\6\1\215\6\6\25\0\1\6\11\0\4\6"+
    "\2\0\21\6\1\216\3\6\25\0\1\6\11\0\4\6"+
    "\2\0\17\6\1\217\5\6\25\0\1\6\11\0\4\6"+
    "\2\0\10\6\1\220\14\6\25\0\1\6\11\0\4\6"+
    "\2\0\6\6\1\221\16\6\25\0\1\6\11\0\4\6"+
    "\2\0\7\6\1\222\15\6\25\0\1\6\11\0\4\6"+
    "\2\0\5\6\1\223\17\6\25\0\1\6\5\0\65\153"+
    "\1\224\4\153\4\0\4\6\2\0\4\6\1\225\20\6"+
    "\25\0\1\6\5\0\1\155\1\226\1\0\67\155\1\156"+
    "\2\153\62\156\1\227\1\153\1\156\1\153\1\156\5\0"+
    "\2\230\1\0\1\231\40\0\1\231\24\0\4\6\2\0"+
    "\1\232\24\6\25\0\1\6\11\0\4\6\2\0\1\233"+
    "\24\6\25\0\1\6\11\0\4\6\2\0\4\6\1\234"+
    "\20\6\25\0\1\6\11\0\4\6\2\0\7\6\1\235"+
    "\15\6\25\0\1\6\11\0\4\6\2\0\11\6\1\236"+
    "\13\6\25\0\1\6\11\0\4\6\2\0\6\6\1\237"+
    "\16\6\25\0\1\6\11\0\4\6\2\0\17\6\1\240"+
    "\5\6\25\0\1\6\11\0\4\6\2\0\22\6\1\241"+
    "\2\6\25\0\1\6\11\0\4\6\2\0\3\6\1\242"+
    "\21\6\25\0\1\6\11\0\4\6\2\0\6\6\1\243"+
    "\16\6\25\0\1\6\11\0\4\6\2\0\17\6\1\244"+
    "\5\6\25\0\1\6\11\0\4\6\2\0\1\245\24\6"+
    "\25\0\1\6\11\0\4\6\2\0\6\6\1\246\16\6"+
    "\25\0\1\6\11\0\4\6\2\0\14\6\1\247\1\6"+
    "\1\250\6\6\25\0\1\6\11\0\4\6\2\0\1\251"+
    "\24\6\25\0\1\6\11\0\4\6\2\0\10\6\1\252"+
    "\14\6\25\0\1\6\11\0\4\6\2\0\1\253\24\6"+
    "\25\0\1\6\11\0\4\6\2\0\4\6\1\254\20\6"+
    "\25\0\1\6\11\0\4\6\2\0\16\6\1\255\6\6"+
    "\25\0\1\6\11\0\4\6\2\0\16\6\1\256\6\6"+
    "\25\0\1\6\11\0\4\6\2\0\1\257\24\6\25\0"+
    "\1\6\11\0\4\6\2\0\4\6\1\260\20\6\25\0"+
    "\1\6\11\0\4\6\2\0\11\6\1\261\13\6\25\0"+
    "\1\6\11\0\4\6\2\0\2\6\1\262\22\6\25\0"+
    "\1\6\11\0\4\6\2\0\1\263\24\6\25\0\1\6"+
    "\11\0\4\6\2\0\11\6\1\264\13\6\25\0\1\6"+
    "\11\0\4\6\2\0\14\6\1\214\10\6\25\0\1\6"+
    "\11\0\4\6\2\0\13\6\1\265\11\6\25\0\1\6"+
    "\5\0\52\153\1\266\12\153\1\224\4\153\4\0\4\6"+
    "\2\0\20\6\1\267\4\6\25\0\1\6\7\0\1\266"+
    "\67\0\1\156\2\153\47\156\1\270\12\156\1\227\1\153"+
    "\1\156\1\153\1\156\5\0\2\230\67\0\4\6\2\0"+
    "\10\6\1\271\14\6\25\0\1\6\11\0\4\6\2\0"+
    "\5\6\1\272\17\6\25\0\1\6\11\0\4\6\2\0"+
    "\12\6\1\273\12\6\25\0\1\6\11\0\4\6\2\0"+
    "\16\6\1\274\6\6\25\0\1\6\11\0\4\6\2\0"+
    "\17\6\1\275\5\6\25\0\1\6\11\0\4\6\2\0"+
    "\10\6\1\276\14\6\25\0\1\6\11\0\4\6\2\0"+
    "\10\6\1\277\14\6\25\0\1\6\11\0\4\6\2\0"+
    "\11\6\1\300\13\6\25\0\1\6\11\0\4\6\2\0"+
    "\16\6\1\301\6\6\25\0\1\6\11\0\4\6\2\0"+
    "\4\6\1\302\20\6\25\0\1\6\11\0\4\6\2\0"+
    "\6\6\1\303\16\6\25\0\1\6\11\0\4\6\2\0"+
    "\5\6\1\304\17\6\25\0\1\6\11\0\4\6\2\0"+
    "\4\6\1\305\20\6\25\0\1\6\11\0\4\6\2\0"+
    "\13\6\1\306\11\6\25\0\1\6\11\0\4\6\2\0"+
    "\7\6\1\307\15\6\25\0\1\6\11\0\4\6\2\0"+
    "\17\6\1\310\5\6\25\0\1\6\11\0\4\6\2\0"+
    "\7\6\1\311\15\6\25\0\1\6\11\0\4\6\2\0"+
    "\11\6\1\312\13\6\25\0\1\6\11\0\4\6\2\0"+
    "\16\6\1\313\6\6\25\0\1\6\11\0\4\6\2\0"+
    "\16\6\1\314\6\6\25\0\1\6\11\0\4\6\2\0"+
    "\5\6\1\315\17\6\25\0\1\6\11\0\4\6\2\0"+
    "\16\6\1\316\6\6\25\0\1\6\11\0\4\6\2\0"+
    "\20\6\1\317\4\6\25\0\1\6\11\0\4\6\2\0"+
    "\5\6\1\320\17\6\25\0\1\6\11\0\4\6\2\0"+
    "\16\6\1\321\6\6\25\0\1\6\11\0\4\6\2\0"+
    "\5\6\1\322\17\6\25\0\1\6\11\0\4\6\2\0"+
    "\21\6\1\323\3\6\25\0\1\6\11\0\4\6\2\0"+
    "\3\6\1\324\21\6\25\0\1\6\11\0\4\6\2\0"+
    "\13\6\1\325\11\6\25\0\1\6\11\0\4\6\2\0"+
    "\15\6\1\326\7\6\25\0\1\6\11\0\4\6\2\0"+
    "\7\6\1\327\15\6\25\0\1\6\11\0\4\6\2\0"+
    "\1\330\24\6\25\0\1\6\11\0\4\6\2\0\13\6"+
    "\1\331\11\6\25\0\1\6\11\0\4\6\2\0\4\6"+
    "\1\332\20\6\25\0\1\6\11\0\4\6\2\0\17\6"+
    "\1\333\5\6\25\0\1\6\11\0\4\6\2\0\16\6"+
    "\1\334\6\6\25\0\1\6\11\0\4\6\2\0\15\6"+
    "\1\335\7\6\25\0\1\6\11\0\4\6\2\0\6\6"+
    "\1\336\16\6\25\0\1\6\11\0\4\6\2\0\1\337"+
    "\24\6\25\0\1\6\11\0\4\6\2\0\5\6\1\340"+
    "\17\6\25\0\1\6\5\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[8700];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\3\0\2\11\24\1\1\11\4\1\4\11\3\1\11\11"+
    "\2\1\2\11\4\1\1\11\7\1\2\0\1\11\1\0"+
    "\1\11\37\1\10\11\1\0\3\1\2\11\2\0\41\1"+
    "\1\0\1\1\1\0\2\1\1\0\34\1\1\11\52\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[224];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */
    /* To create a new java_cup.runtime.Symbol with information about
       the current token, the token will have no value in this
       case. */
    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }

    /* Also creates a new java_cup.runtime.Symbol with information
       about the current token, but this object has a value. */
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }
    StringBuilder string = new StringBuilder();



  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Yylex(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 184) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
          { return new java_cup.runtime.Symbol(sym.EOF); }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { System.out.println("shit");throw new Error("Illegal character <"+yytext()+">");
            }
          case 83: break;
          case 2: 
            { /*return symbol(sym.WHITE, yytext() );*/
            }
          case 84: break;
          case 3: 
            { return symbol(sym.ID, yytext() );
            }
          case 85: break;
          case 4: 
            { return symbol(sym.INT_CONST, yytext() );
            }
          case 86: break;
          case 5: 
            { return symbol(sym.MINUS,yytext());
            }
          case 87: break;
          case 6: 
            { return symbol(sym.SEMI,yytext());
            }
          case 88: break;
          case 7: 
            { return symbol(sym.EQUAL,yytext());
            }
          case 89: break;
          case 8: 
            { return symbol(sym.EXCLEM,yytext());
            }
          case 90: break;
          case 9: 
            { return symbol(sym.SMALLER,yytext());
            }
          case 91: break;
          case 10: 
            { return symbol(sym.BIGGER,yytext());
            }
          case 92: break;
          case 11: 
            { return symbol(sym.TILDA,yytext());
            }
          case 93: break;
          case 12: 
            { return symbol(sym.AND,yytext());
            }
          case 94: break;
          case 13: 
            { return symbol(sym.OR,yytext());
            }
          case 95: break;
          case 14: 
            { return symbol(sym.CAROT,yytext());
            }
          case 96: break;
          case 15: 
            { return symbol(sym.MULT,yytext());
            }
          case 97: break;
          case 16: 
            { return symbol(sym.PLUS,yytext());
            }
          case 98: break;
          case 17: 
            { return symbol(sym.DIVIDE,yytext());
            }
          case 99: break;
          case 18: 
            { return symbol(sym.MOD,yytext());
            }
          case 100: break;
          case 19: 
            { return symbol(sym.OPENCURLBRAK,yytext());
            }
          case 101: break;
          case 20: 
            { return symbol(sym.CLOSEDCURLBRAK,yytext());
            }
          case 102: break;
          case 21: 
            { return symbol(sym.OPENPRANTHES,yytext());
            }
          case 103: break;
          case 22: 
            { return symbol(sym.CLOSEDPRANTHES,yytext());
            }
          case 104: break;
          case 23: 
            { return symbol(sym.OPENBRAK,yytext());
            }
          case 105: break;
          case 24: 
            { return symbol(sym.CLOSEDBRAK,yytext());
            }
          case 106: break;
          case 25: 
            { return symbol(sym.DOUBLEDOT,yytext());
            }
          case 107: break;
          case 26: 
            { return symbol(sym.COMMA,yytext());
            }
          case 108: break;
          case 27: 
            { yybegin(STRING); string.setLength(0); string.append("\"");
            }
          case 109: break;
          case 28: 
            { yybegin(CHAR);
            }
          case 110: break;
          case 29: 
            { string.append( yytext() );
            }
          case 111: break;
          case 30: 
            { yybegin(YYINITIAL); StringBuilder temp = string ; string = new StringBuilder(); return symbol(sym.STRING_CONST, temp.toString() );
            }
          case 112: break;
          case 31: 
            { return symbol(sym.REAL_CONST, yytext() );
            }
          case 113: break;
          case 32: 
            { return symbol(sym.MM,yytext());
            }
          case 114: break;
          case 33: 
            { return symbol(sym.MINUSEQUAL,yytext());
            }
          case 115: break;
          case 34: 
            { return symbol(sym.IN,yytext());
            }
          case 116: break;
          case 35: 
            { return symbol(sym.IF, yytext() ) ;
            }
          case 117: break;
          case 36: 
            { return symbol(sym.ORC,yytext());
            }
          case 118: break;
          case 37: 
            { return symbol(sym.OF,yytext());
            }
          case 119: break;
          case 38: 
            { return symbol(sym.EQEQUAL,yytext());
            }
          case 120: break;
          case 39: 
            { return symbol(sym.NOTEQUAL,yytext());
            }
          case 121: break;
          case 40: 
            { return symbol(sym.SMALLEQUAL,yytext());
            }
          case 122: break;
          case 41: 
            { return symbol(sym.BIGEQUAL,yytext());
            }
          case 123: break;
          case 42: 
            { return symbol(sym.MULTEQUAL,yytext());
            }
          case 124: break;
          case 43: 
            { return symbol(sym.PLUSEQUAL,yytext());
            }
          case 125: break;
          case 44: 
            { return symbol(sym.PP,yytext());
            }
          case 126: break;
          case 45: 
            { return symbol(sym.DIVIDEEQUAL,yytext());
            }
          case 127: break;
          case 46: 
            { 
            }
          case 128: break;
          case 47: 
            { string.append(yytext()  );
            }
          case 129: break;
          case 48: 
            { yybegin(YYINITIAL); return symbol(sym.CHAR_CONST, yytext() );
            }
          case 130: break;
          case 49: 
            { return symbol(sym.END, yytext() ) ;
            }
          case 131: break;
          case 50: 
            { return symbol(sym.INT, yytext() ) ;
            }
          case 132: break;
          case 51: 
            { return symbol(sym.NOTC,yytext());
            }
          case 133: break;
          case 52: 
            { return symbol(sym.ANDC,yytext());
            }
          case 134: break;
          case 53: 
            { return symbol(sym.FOR, yytext() ) ;
            }
          case 135: break;
          case 54: 
            { return symbol(sym.ELSE, yytext() ) ;
            }
          case 136: break;
          case 55: 
            { return symbol(sym.BOOL, yytext() ) ;
            }
          case 137: break;
          case 56: 
            { return symbol(sym.GOTO, yytext() ) ;
            }
          case 138: break;
          case 57: 
            { return symbol(sym.LONG, yytext() ) ;
            }
          case 139: break;
          case 58: 
            { return symbol(sym.AUTO,yytext());
            }
          case 140: break;
          case 59: 
            { return symbol(sym.CASE, yytext() ) ;
            }
          case 141: break;
          case 60: 
            { return symbol(sym.CHAR, yytext() ) ;
            }
          case 142: break;
          case 61: 
            { return symbol(sym.BOOL_CONST, yytext() ) ;
            }
          case 143: break;
          case 62: 
            { return symbol(sym.VOID,yytext());
            }
          case 144: break;
          case 63: 
            { return symbol(sym.BEGIN, yytext() ) ;
            }
          case 145: break;
          case 64: 
            { return symbol(sym.BREAK, yytext() ) ;
            }
          case 146: break;
          case 65: 
            { return symbol(sym.INPUT, yytext() ) ;
            }
          case 147: break;
          case 66: 
            { return symbol(sym.CONST, yytext() ) ;
            }
          case 148: break;
          case 67: 
            { return symbol(sym.UNITL,yytext());
            }
          case 149: break;
          case 68: 
            { return symbol(sym.FLOAT, yytext() ) ;
            }
          case 150: break;
          case 69: 
            { return symbol(sym.EXTERN, yytext() ) ;
            }
          case 151: break;
          case 70: 
            { return symbol(sym.OUTPUT, yytext() ) ;
            }
          case 152: break;
          case 71: 
            { return symbol(sym.RECORD, yytext() ) ;
            }
          case 153: break;
          case 72: 
            { return symbol(sym.RETURN, yytext() ) ;
            }
          case 154: break;
          case 73: 
            { return symbol(sym.REPEAT,yytext());
            }
          case 155: break;
          case 74: 
            { return symbol(sym.SIZEOF, yytext() ) ;
            }
          case 156: break;
          case 75: 
            { return symbol(sym.STRING, yytext() ) ;
            }
          case 157: break;
          case 76: 
            { return symbol(sym.STATIC, yytext() ) ;
            }
          case 158: break;
          case 77: 
            { return symbol(sym.SWITCH, yytext() ) ;
            }
          case 159: break;
          case 78: 
            { return symbol(sym.DOUBLE, yytext() ) ;
            }
          case 160: break;
          case 79: 
            { return symbol(sym.DEFAULT, yytext() ) ;
            }
          case 161: break;
          case 80: 
            { return symbol(sym.FOREACH,yytext());
            }
          case 162: break;
          case 81: 
            { return symbol(sym.CONTINUE, yytext() ) ;
            }
          case 163: break;
          case 82: 
            { return symbol(sym.FUNCTION, yytext() ) ;
            }
          case 164: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
