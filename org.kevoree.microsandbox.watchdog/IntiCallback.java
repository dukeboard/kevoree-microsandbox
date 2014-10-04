import dacapo.Callback;

/**
 * @date $Date: 2009-12-24 11:19:36 +1100 (Thu, 24 Dec 2009) $
 * @id $Id: MyCallback.java 738 2009-12-24 00:19:36Z steveb-oss $
 */
public class IntiCallback extends Callback {

  public IntiCallback() {
    super();
  }

  public void complete(String benchmark, boolean valid) {
    super.complete(benchmark, valid);
    System.err.println("my hook " + (valid ? "PASSED " : "FAILED ") + (isWarmup() ? "warmup " : "") + benchmark);
    System.err.flush();
  };
}