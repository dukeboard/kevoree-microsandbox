package org.kevoree.microsandbox.test;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.kevoree.microsandbox.api.event.ContractViolationEvent;
import org.kevoree.microsandbox.api.event.MonitoringNotification;
import org.kevoree.microsandbox.api.sla.Metric;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: Erwan Daubert - erwan.daubert@gmail.com
 * Date: 04/07/13
 * Time: 10:27
 *
 * @author Erwan Daubert
 * @version 1.0
 */
// needed to be able to use @BeforeClass (why ?)
@RunWith(JUnit4.class)
public class NetworkContractedTester extends AbstractMicroSandboxTester {

    private static final String webContent = "<!DOCTYPE html><html><head>\n" +
            "    \n" +
            "\n" +
            "    <title>Dashboard [Jenkins]</title><link rel=\"stylesheet\" type=\"text/css\" href=\"/static/f20eb0f9/css/style.css\" /><link rel=\"stylesheet\" type=\"text/css\" href=\"/static/f20eb0f9/css/color.css\" /><link rel=\"shortcut icon\" type=\"image/vnd.microsoft.icon\" href=\"/static/f20eb0f9/favicon.ico\" /><script>var isRunAsTest=false; var rootURL=\"\"; var resURL=\"/static/f20eb0f9\";</script><script src=\"/static/f20eb0f9/scripts/prototype.js\" type=\"text/javascript\"></script><script src=\"/static/f20eb0f9/scripts/behavior.js\" type=\"text/javascript\"></script><script src='/adjuncts/f20eb0f9/org/kohsuke/stapler/bind.js' type='text/javascript'></script><script src=\"/static/f20eb0f9/scripts/yui/yahoo/yahoo-min.js\"></script><script src=\"/static/f20eb0f9/scripts/yui/dom/dom-min.js\"></script><script src=\"/static/f20eb0f9/scripts/yui/event/event-min.js\"></script><script src=\"/static/f20eb0f9/scripts/yui/animation/animation-min.js\"></script><script src=\"/static/f20eb0f9/scripts/yui/dragdrop/dragdrop-min.js\"></script><script src=\"/static/f20eb0f9/scripts/yui/container/container-min.js\"></script><script src=\"/static/f20eb0f9/scripts/yui/connection/connection-min.js\"></script><script src=\"/static/f20eb0f9/scripts/yui/datasource/datasource-min.js\"></script><script src=\"/static/f20eb0f9/scripts/yui/autocomplete/autocomplete-min.js\"></script><script src=\"/static/f20eb0f9/scripts/yui/menu/menu-min.js\"></script><script src=\"/static/f20eb0f9/scripts/yui/element/element-min.js\"></script><script src=\"/static/f20eb0f9/scripts/yui/button/button-min.js\"></script><script src=\"/static/f20eb0f9/scripts/yui/storage/storage-min.js\"></script><script src=\"/static/f20eb0f9/scripts/hudson-behavior.js\" type=\"text/javascript\"></script><script src=\"/static/f20eb0f9/scripts/sortable.js\" type=\"text/javascript\"></script><script>crumb.init(\"\", \"\");</script><link rel=\"stylesheet\" type=\"text/css\" href=\"/static/f20eb0f9/scripts/yui/container/assets/container.css\" /><link rel=\"stylesheet\" type=\"text/css\" href=\"/static/f20eb0f9/scripts/yui/assets/skins/sam/skin.css\" /><link rel=\"stylesheet\" type=\"text/css\" href=\"/static/f20eb0f9/scripts/yui/container/assets/skins/sam/container.css\" /><link rel=\"stylesheet\" type=\"text/css\" href=\"/static/f20eb0f9/scripts/yui/button/assets/skins/sam/button.css\" /><link rel=\"stylesheet\" type=\"text/css\" href=\"/static/f20eb0f9/scripts/yui/menu/assets/skins/sam/menu.css\" /><link title=\"Jenkins\" rel=\"search\" type=\"application/opensearchdescription+xml\" href=\"/opensearch.xml\" /><meta name=\"ROBOTS\" content=\"INDEX,NOFOLLOW\" /><link title=\"Jenkins:All (all builds)\" rel=\"alternate\" type=\"application/rss+xml\" href=\"/rssAll\" /><link title=\"Jenkins:All (all builds) (RSS 2.0)\" rel=\"alternate\" type=\"application/rss+xml\" href=\"/rssAll?flavor=rss20\" /><link title=\"Jenkins:All (failed builds)\" rel=\"alternate\" type=\"application/rss+xml\" href=\"/rssFailed\" /><link title=\"Jenkins:All (failed builds) (RSS 2.0)\" rel=\"alternate\" type=\"application/rss+xml\" href=\"/rssFailed?flavor=rss20\" /><script src=\"/static/f20eb0f9/scripts/yui/cookie/cookie-min.js\"></script><script>\n" +
            "              YAHOO.util.Cookie.set(\"screenResolution\", screen.width+\"x\"+screen.height);\n" +
            "            </script><script src=\"/static/f20eb0f9/scripts/yui/cookie/cookie-min.js\"></script></head><body class=\"yui-skin-sam\"><a href=\"#skip2content\" class=\"skiplink\">Skip to content</a><table id=\"header\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\"><tr><td id=\"top-panel\" colspan=\"2\"><table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\"><tr><td style=\"font-weight:bold; font-size: 2em;\"><a href=\"/\"><img height=\"34\" alt=\"title\" width=\"139\" src=\"/static/f20eb0f9/images/title.png\" /></a></td><td style=\"vertical-align: middle; text-align: right; padding-right: 1em;\"><form style=\"position:relative;\" name=\"search\" action=\"/search/\" class=\"no-json\" method=\"get\"><div id=\"search-box-minWidth\"></div><div id=\"search-box-sizer\"></div><div id=\"searchform\"><input id=\"search-box\" placeholder=\"search\" name=\"q\" class=\"has-default-text\" /> <a href=\"http://wiki.jenkins-ci.org/display/JENKINS/Search+Box\"><img height=\"16\" alt=\"help for search\" width=\"16\" src=\"/static/f20eb0f9/images/16x16/help.png\" /></a><div id=\"search-box-completion\"></div><script>createSearchBox(\"/search/\");</script></div></form></td><td id=\"login-field\"><span></span></td></tr></table></td></tr><tr id=\"top-nav\"><td id=\"left-top-nav\" colspan=\"2\"><link rel='stylesheet' href='/adjuncts/f20eb0f9/lib/layout/breadcrumbs.css' type='text/css' /><script src='/adjuncts/f20eb0f9/lib/layout/breadcrumbs.js' type='text/javascript'></script><div class=\"top-sticker noedge\"><div class=\"top-sticker-inner\"><div id=\"right-top-nav\"><div id=\"right-top-nav\"><div class=\"smallfont\"><a href=\"?auto_refresh=true\">ENABLE AUTO REFRESH</a></div></div></div><ul id=\"breadcrumbs\"><li class=\"item\"><a class=\"model-link inside\" href=\"/\">Jenkins</a></li><li class=\"children\" href=\"/\"></li></ul><div id=\"breadcrumb-menu-target\"></div></div></div></td></tr></table><table id=\"main-table\" height=\"70%\" style=\"background-image: url(/static/f20eb0f9/images/jenkins.png);                background-repeat: no-repeat; background-position: bottom left;\" width=\"100%\" border=\"0\"><tr><td id=\"side-panel\" width=\"20%\"><div id=\"navigation\" style=\"min-height: 323px; height: auto !important; height: 323px;\"><div id=\"tasks\"><div class=\"task\">\n" +
            "          \n" +
            "\n" +
            "          <a href=\"/view/All/newJob\"><img height=\"24\" style=\"margin: 2px;\" alt=\"\" width=\"24\" src=\"/static/f20eb0f9/images/24x24/new-package.png\" /></a> <a href=\"/view/All/newJob\">New Job</a></div><div class=\"task\">\n" +
            "          \n" +
            "\n" +
            "          <a href=\"/asynchPeople/\"><img height=\"24\" style=\"margin: 2px;\" alt=\"\" width=\"24\" src=\"/static/f20eb0f9/images/24x24/user.png\" /></a> <a href=\"/asynchPeople/\">People</a></div><div class=\"task\">\n" +
            "          \n" +
            "\n" +
            "          <a href=\"/view/All/builds\"><img height=\"24\" style=\"margin: 2px;\" alt=\"\" width=\"24\" src=\"/static/f20eb0f9/images/24x24/notepad.png\" /></a> <a href=\"/view/All/builds\">Build History</a></div><div class=\"task\">\n" +
            "          \n" +
            "\n" +
            "          <a href=\"/projectRelationship\"><img height=\"24\" style=\"margin: 2px;\" alt=\"\" width=\"24\" src=\"/static/f20eb0f9/images/24x24/search.png\" /></a> <a href=\"/projectRelationship\">Project Relationship</a></div><div class=\"task\">\n" +
            "          \n" +
            "\n" +
            "          <a href=\"/fingerprintCheck\"><img height=\"24\" style=\"margin: 2px;\" alt=\"\" width=\"24\" src=\"/static/f20eb0f9/images/24x24/fingerprint.png\" /></a> <a href=\"/fingerprintCheck\">Check File Fingerprint</a></div><div class=\"task\">\n" +
            "          \n" +
            "\n" +
            "          <a href=\"/manage\"><img height=\"24\" style=\"margin: 2px;\" alt=\"\" width=\"24\" src=\"/static/f20eb0f9/images/24x24/setting.png\" /></a> <a href=\"/manage\">Manage Jenkins</a></div></div><table id=\"buildQueue\" class=\"pane\"><tr><td colspan=\"2\" class=\"pane-header\">Build Queue</td></tr><tr><td class=\"pane\" colspan=\"2\">No builds in the queue.</td></tr></table><script defer=\"defer\">refreshPart('buildQueue',\"/ajaxBuildQueue\");</script><table id=\"executors\" class=\"pane\"><tr><td colspan=\"3\" class=\"pane-header\"><a href='/computer/'>Build Executor Status</a></td></tr><colgroup><col width=\"1*\" /><col width=\"200*\" /><col width=\"24\" /></colgroup><tr><th class=\"pane\">#</th><th class=\"pane\" colspan=\"2\"><div style=\"margin-right:19px\">Status</div></th></tr><tr></tr><tr><td class=\"pane\" align=\"right\" style=\"vertical-align: top\">1</td><td class=\"pane\">Idle</td><td class=\"pane\"></td></tr><tr><td class=\"pane\" align=\"right\" style=\"vertical-align: top\">2</td><td class=\"pane\">Idle</td><td class=\"pane\"></td></tr></table><script defer=\"defer\">refreshPart('executors',\"/ajaxExecutors\");</script></div></td><td id=\"main-panel\" width=\"80%\" height=\"100%\"><a name=\"skip2content\"></a><div id=\"view-message\"><div id=\"description\"><div></div><div align=\"right\"><a onclick=\"return replaceDescription();\" href=\"editDescription\"><img height=\"16\" alt=\"\" width=\"16\" src=\"/static/f20eb0f9/images/16x16/notepad.png\" />add description</a></div></div></div><div class=\"dashboard\"><table cellpadding=\"0\" cellspacing=\"0\" id=\"viewList\"><tr style=\"height:3px;\"><td style=\"height:3px; padding:0px\"></td><td class=\"active\" rowspan=\"2\">All</td><td style=\"height:3px; padding:0px\"></td></tr><tr><td style=\"border: none; border-bottom: 1px solid #bbb;\"> </td><td class=\"inactive noLeft\"><a title=\"New View\" href=\"/newView\">+</a></td><td class=\"filler\"> </td></tr></table><table id=\"projectstatus\" style=\"margin-top:0px; border-top: none;\" class=\"sortable pane bigtable\"><tr style=\"border-top: 0px;\"><th tooltip=\"Status of the last build\">&nbsp;&nbsp;&nbsp;S</th><th tooltip=\"Weather report showing aggregated status of recent builds\">&nbsp;&nbsp;&nbsp;W</th><th initialSortDir=\"down\">Name</th><th>Last Success</th><th>Last Failure</th><th>Last Duration</th><th width=\"1\"> </th><th> </th></tr><tr id=\"job_DAUM\"><td data=\"0\"><img alt=\"Failed\" class=\"icon32x32\" src=\"/static/f20eb0f9/images/32x32/red.png\" tooltip=\"Failed\" /></td><td data=\"0\" class=\"healthReport\" onmouseover=\"this.className='healthReport hover';return true;\n" +
            "        \" onmouseout=\"this.className='healthReport';return true;\"><a href=\"job/DAUM/lastBuild\"><img alt=\"0%\" class=\"icon32x32\" src=\"/static/f20eb0f9/images/32x32/health-00to19.png\" /></a><div class=\"healthReportDetails\"><table border=\"0\"><thead><tr><th align=\"left\">W</th><th align=\"left\">Description</th><th align=\"right\">%</th></tr></thead><tbody><tr><td align=\"left\"><img title=\"\" alt=\"\" src=\"/static/f20eb0f9/images/16x16/health-00to19.png\" /></td><td>Build stability: All recent builds failed.</td><td align=\"right\">0</td></tr></tbody></table></div></td><td><a class=\"model-link inside\" href=\"job/DAUM/\">\n" +
            "  DAUM\n" +
            "</a></td><td data=\"-\">N/A</td><td data=\"2013-07-21T12:01:44Z\">\n" +
            "        20 hr\n" +
            "        - <a class=\"model-link inside\" href=\"job/DAUM/lastFailedBuild/\">#9</a></td><td data=\"3018\">3 sec</td><td><a href=\"job/DAUM/build?delay=0sec\"><img title=\"Schedule a build\" alt=\"Schedule a build\" onclick=\"return build_id596006(this)\" src=\"/static/f20eb0f9/images/24x24/clock.png\" border=\"0\" /></a><script>function build_id596006(img) {\n" +
            "                  new Ajax.Request(img.parentNode.href);\n" +
            "                  hoverNotification('Build scheduled', img, -100);\n" +
            "                  return false;\n" +
            "                }</script></td><td> </td></tr><tr id=\"job_Kevoree\"><td data=\"4\"><img alt=\"Success\" class=\"icon32x32\" src=\"/static/f20eb0f9/images/32x32/blue.png\" tooltip=\"Success\" /></td><td data=\"100\" class=\"healthReport\" onmouseover=\"this.className='healthReport hover';return true;\n" +
            "        \" onmouseout=\"this.className='healthReport';return true;\"><a href=\"job/Kevoree/lastBuild\"><img alt=\"100%\" class=\"icon32x32\" src=\"/static/f20eb0f9/images/32x32/health-80plus.png\" /></a><div class=\"healthReportDetails\"><table border=\"0\"><thead><tr><th align=\"left\">W</th><th align=\"left\">Description</th><th align=\"right\">%</th></tr></thead><tbody><tr><td align=\"left\"><img title=\"\" alt=\"\" src=\"/static/f20eb0f9/images/16x16/health-80plus.png\" /></td><td>Test Result: 0 tests failing out of a total of 162 tests.</td><td align=\"right\">100</td></tr><tr><td align=\"left\"><img title=\"\" alt=\"\" src=\"/static/f20eb0f9/images/16x16/health-80plus.png\" /></td><td>Build stability: No recent builds failed.</td><td align=\"right\">100</td></tr></tbody></table></div></td><td><a class=\"model-link inside\" href=\"job/Kevoree/\">\n" +
            "  Kevoree\n" +
            "</a></td><td data=\"2013-07-22T00:56:44Z\">\n" +
            "        8 hr 3 min\n" +
            "        - <a class=\"model-link inside\" href=\"job/Kevoree/lastSuccessfulBuild/\">#26</a></td><td data=\"2013-07-19T12:56:44Z\">\n" +
            "        2 days 20 hr\n" +
            "        - <a class=\"model-link inside\" href=\"job/Kevoree/lastFailedBuild/\">#21</a></td><td data=\"4264767\">1 hr 11 min</td><td><a href=\"job/Kevoree/build?delay=0sec\"><img title=\"Schedule a build\" alt=\"Schedule a build\" onclick=\"return build_id596007(this)\" src=\"/static/f20eb0f9/images/24x24/clock.png\" border=\"0\" /></a><script>function build_id596007(img) {\n" +
            "                  new Ajax.Request(img.parentNode.href);\n" +
            "                  hoverNotification('Build scheduled', img, -100);\n" +
            "                  return false;\n" +
            "                }</script></td><td> </td></tr><tr id=\"job_Kevoree-extra\" class=\"disabledJob\"><td data=\"8\"><img alt=\"Disabled\" class=\"icon32x32\" src=\"/static/f20eb0f9/images/32x32/grey.png\" tooltip=\"Disabled\" /></td><td data=\"100\" class=\"healthReport\" onmouseover=\"this.className='healthReport hover';return true;\n" +
            "        \" onmouseout=\"this.className='healthReport';return true;\"><img alt=\"100%\" class=\"icon32x32\" src=\"/static/f20eb0f9/images/32x32/empty.png\" /></td><td><a class=\"model-link inside\" href=\"job/Kevoree-extra/\">\n" +
            "  Kevoree<wbr>-extra\n" +
            "</a></td><td data=\"-\">N/A</td><td data=\"-\">N/A</td><td data=\"0\">N/A</td><td></td><td> </td></tr><tr id=\"job_Kevoree-Library\"><td data=\"0\"><img alt=\"Failed\" class=\"icon32x32\" src=\"/static/f20eb0f9/images/32x32/red.png\" tooltip=\"Failed\" /></td><td data=\"0\" class=\"healthReport\" onmouseover=\"this.className='healthReport hover';return true;\n" +
            "        \" onmouseout=\"this.className='healthReport';return true;\"><a href=\"job/Kevoree-Library/lastBuild\"><img alt=\"0%\" class=\"icon32x32\" src=\"/static/f20eb0f9/images/32x32/health-00to19.png\" /></a><div class=\"healthReportDetails\"><table border=\"0\"><thead><tr><th align=\"left\">W</th><th align=\"left\">Description</th><th align=\"right\">%</th></tr></thead><tbody><tr><td align=\"left\"><img title=\"\" alt=\"\" src=\"/static/f20eb0f9/images/16x16/health-00to19.png\" /></td><td>Build stability: All recent builds failed.</td><td align=\"right\">0</td></tr></tbody></table></div></td><td><a class=\"model-link inside\" href=\"job/Kevoree-Library/\">\n" +
            "  Kevoree<wbr>-Library\n" +
            "</a></td><td data=\"-\">N/A</td><td data=\"2013-07-21T23:27:44Z\">\n" +
            "        9 hr 32 min\n" +
            "        - <a class=\"model-link inside\" href=\"job/Kevoree-Library/lastFailedBuild/\">#10</a></td><td data=\"39856\">39 sec</td><td><a href=\"job/Kevoree-Library/build?delay=0sec\"><img title=\"Schedule a build\" alt=\"Schedule a build\" onclick=\"return build_id596008(this)\" src=\"/static/f20eb0f9/images/24x24/clock.png\" border=\"0\" /></a><script>function build_id596008(img) {\n" +
            "                  new Ajax.Request(img.parentNode.href);\n" +
            "                  hoverNotification('Build scheduled', img, -100);\n" +
            "                  return false;\n" +
            "                }</script></td><td> </td></tr><tr id=\"job_Kevoree-Microsandbox\"><td data=\"4\"><img alt=\"Success\" class=\"icon32x32\" src=\"/static/f20eb0f9/images/32x32/blue.png\" tooltip=\"Success\" /></td><td data=\"100\" class=\"healthReport\" onmouseover=\"this.className='healthReport hover';return true;\n" +
            "        \" onmouseout=\"this.className='healthReport';return true;\"><a href=\"job/Kevoree-Microsandbox/lastBuild\"><img alt=\"100%\" class=\"icon32x32\" src=\"/static/f20eb0f9/images/32x32/health-80plus.png\" /></a><div class=\"healthReportDetails\"><table border=\"0\"><thead><tr><th align=\"left\">W</th><th align=\"left\">Description</th><th align=\"right\">%</th></tr></thead><tbody><tr><td align=\"left\"><img title=\"\" alt=\"\" src=\"/static/f20eb0f9/images/16x16/health-80plus.png\" /></td><td>Test Result: 0 tests failing out of a total of 1 test.</td><td align=\"right\">100</td></tr><tr><td align=\"left\"><img title=\"\" alt=\"\" src=\"/static/f20eb0f9/images/16x16/health-80plus.png\" /></td><td>Build stability: No recent builds failed.</td><td align=\"right\">100</td></tr></tbody></table></div></td><td><a class=\"model-link inside\" href=\"job/Kevoree-Microsandbox/\">\n" +
            "  Kevoree<wbr>-Microsandbox\n" +
            "</a></td><td data=\"2013-07-22T03:19:04Z\">\n" +
            "        5 hr 41 min\n" +
            "        - <a class=\"model-link inside\" href=\"job/Kevoree-Microsandbox/lastSuccessfulBuild/\">#18</a></td><td data=\"-\">N/A</td><td data=\"390787\">6 min 30 sec</td><td><a href=\"job/Kevoree-Microsandbox/build?delay=0sec\"><img title=\"Schedule a build\" alt=\"Schedule a build\" onclick=\"return build_id596009(this)\" src=\"/static/f20eb0f9/images/24x24/clock.png\" border=\"0\" /></a><script>function build_id596009(img) {\n" +
            "                  new Ajax.Request(img.parentNode.href);\n" +
            "                  hoverNotification('Build scheduled', img, -100);\n" +
            "                  return false;\n" +
            "                }</script></td><td> </td></tr><tr id=\"job_Kevoree-Talks\"><td data=\"4\"><img alt=\"Success\" class=\"icon32x32\" src=\"/static/f20eb0f9/images/32x32/blue.png\" tooltip=\"Success\" /></td><td data=\"100\" class=\"healthReport\" onmouseover=\"this.className='healthReport hover';return true;\n" +
            "        \" onmouseout=\"this.className='healthReport';return true;\"><a href=\"job/Kevoree-Talks/lastBuild\"><img alt=\"100%\" class=\"icon32x32\" src=\"/static/f20eb0f9/images/32x32/health-80plus.png\" /></a><div class=\"healthReportDetails\"><table border=\"0\"><thead><tr><th align=\"left\">W</th><th align=\"left\">Description</th><th align=\"right\">%</th></tr></thead><tbody><tr><td align=\"left\"><img title=\"\" alt=\"\" src=\"/static/f20eb0f9/images/16x16/health-80plus.png\" /></td><td>Build stability: No recent builds failed.</td><td align=\"right\">100</td></tr></tbody></table></div></td><td><a class=\"model-link inside\" href=\"job/Kevoree-Talks/\">\n" +
            "  Kevoree<wbr>-Talks\n" +
            "</a></td><td data=\"2013-07-22T02:22:44Z\">\n" +
            "        6 hr 37 min\n" +
            "        - <a class=\"model-link inside\" href=\"job/Kevoree-Talks/lastSuccessfulBuild/\">#10</a></td><td data=\"2013-07-13T02:21:20Z\">\n" +
            "        9 days 6 hr\n" +
            "        - <a class=\"model-link inside\" href=\"job/Kevoree-Talks/lastFailedBuild/\">#1</a></td><td data=\"443471\">7 min 23 sec</td><td><a href=\"job/Kevoree-Talks/build?delay=0sec\"><img title=\"Schedule a build\" alt=\"Schedule a build\" onclick=\"return build_id596010(this)\" src=\"/static/f20eb0f9/images/24x24/clock.png\" border=\"0\" /></a><script>function build_id596010(img) {\n" +
            "                  new Ajax.Request(img.parentNode.href);\n" +
            "                  hoverNotification('Build scheduled', img, -100);\n" +
            "                  return false;\n" +
            "                }</script></td><td> </td></tr><tr id=\"job_KevoreeCoreLibrary\"><td data=\"4\"><img alt=\"Success\" class=\"icon32x32\" src=\"/static/f20eb0f9/images/32x32/blue.png\" tooltip=\"Success\" /></td><td data=\"100\" class=\"healthReport\" onmouseover=\"this.className='healthReport hover';return true;\n" +
            "        \" onmouseout=\"this.className='healthReport';return true;\"><a href=\"job/KevoreeCoreLibrary/lastBuild\"><img alt=\"100%\" class=\"icon32x32\" src=\"/static/f20eb0f9/images/32x32/health-80plus.png\" /></a><div class=\"healthReportDetails\"><table border=\"0\"><thead><tr><th align=\"left\">W</th><th align=\"left\">Description</th><th align=\"right\">%</th></tr></thead><tbody><tr><td align=\"left\"><img title=\"\" alt=\"\" src=\"/static/f20eb0f9/images/16x16/health-80plus.png\" /></td><td>Test Result: 0 tests in total.</td><td align=\"right\">100</td></tr><tr><td align=\"left\"><img title=\"\" alt=\"\" src=\"/static/f20eb0f9/images/16x16/health-80plus.png\" /></td><td>Build stability: No recent builds failed.</td><td align=\"right\">100</td></tr></tbody></table></div></td><td><a class=\"model-link inside\" href=\"job/KevoreeCoreLibrary/\">\n" +
            "  KevoreeCor<wbr>eLibrary\n" +
            "</a></td><td data=\"2013-07-22T02:07:54Z\">\n" +
            "        6 hr 52 min\n" +
            "        - <a class=\"model-link inside\" href=\"job/KevoreeCoreLibrary/lastSuccessfulBuild/\">#19</a></td><td data=\"2013-07-17T13:16:44Z\">\n" +
            "        4 days 19 hr\n" +
            "        - <a class=\"model-link inside\" href=\"job/KevoreeCoreLibrary/lastFailedBuild/\">#11</a></td><td data=\"4264852\">1 hr 11 min</td><td><a href=\"job/KevoreeCoreLibrary/build?delay=0sec\"><img title=\"Schedule a build\" alt=\"Schedule a build\" onclick=\"return build_id596011(this)\" src=\"/static/f20eb0f9/images/24x24/clock.png\" border=\"0\" /></a><script>function build_id596011(img) {\n" +
            "                  new Ajax.Request(img.parentNode.href);\n" +
            "                  hoverNotification('Build scheduled', img, -100);\n" +
            "                  return false;\n" +
            "                }</script></td><td> </td></tr><tr id=\"job_KevoreeWatchdog\"><td data=\"4\"><img alt=\"Success\" class=\"icon32x32\" src=\"/static/f20eb0f9/images/32x32/blue.png\" tooltip=\"Success\" /></td><td data=\"100\" class=\"healthReport\" onmouseover=\"this.className='healthReport hover';return true;\n" +
            "        \" onmouseout=\"this.className='healthReport';return true;\"><a href=\"job/KevoreeWatchdog/lastBuild\"><img alt=\"100%\" class=\"icon32x32\" src=\"/static/f20eb0f9/images/32x32/health-80plus.png\" /></a><div class=\"healthReportDetails\"><table border=\"0\"><thead><tr><th align=\"left\">W</th><th align=\"left\">Description</th><th align=\"right\">%</th></tr></thead><tbody><tr><td align=\"left\"><img title=\"\" alt=\"\" src=\"/static/f20eb0f9/images/16x16/health-80plus.png\" /></td><td>Build stability: No recent builds failed.</td><td align=\"right\">100</td></tr></tbody></table></div></td><td><a class=\"model-link inside\" href=\"job/KevoreeWatchdog/\">\n" +
            "  KevoreeWat<wbr>chdog\n" +
            "</a></td><td data=\"2013-07-21T19:13:44Z\">\n" +
            "        13 hr\n" +
            "        - <a class=\"model-link inside\" href=\"job/KevoreeWatchdog/lastSuccessfulBuild/\">#11</a></td><td data=\"2013-07-16T19:12:20Z\">\n" +
            "        5 days 13 hr\n" +
            "        - <a class=\"model-link inside\" href=\"job/KevoreeWatchdog/lastFailedBuild/\">#5</a></td><td data=\"111577\">1 min 51 sec</td><td><a href=\"job/KevoreeWatchdog/build?delay=0sec\"><img title=\"Schedule a build\" alt=\"Schedule a build\" onclick=\"return build_id596012(this)\" src=\"/static/f20eb0f9/images/24x24/clock.png\" border=\"0\" /></a><script>function build_id596012(img) {\n" +
            "                  new Ajax.Request(img.parentNode.href);\n" +
            "                  hoverNotification('Build scheduled', img, -100);\n" +
            "                  return false;\n" +
            "                }</script></td><td> </td></tr><tr id=\"job_KevoreeWeb Compile\" class=\"disabledJob\"><td data=\"8\"><img alt=\"Disabled\" class=\"icon32x32\" src=\"/static/f20eb0f9/images/32x32/grey.png\" tooltip=\"Disabled\" /></td><td data=\"0\" class=\"healthReport\" onmouseover=\"this.className='healthReport hover';return true;\n" +
            "        \" onmouseout=\"this.className='healthReport';return true;\"><a href=\"job/KevoreeWeb%20Compile/lastBuild\"><img alt=\"0%\" class=\"icon32x32\" src=\"/static/f20eb0f9/images/32x32/health-00to19.png\" /></a><div class=\"healthReportDetails\"><table border=\"0\"><thead><tr><th align=\"left\">W</th><th align=\"left\">Description</th><th align=\"right\">%</th></tr></thead><tbody><tr><td align=\"left\"><img title=\"\" alt=\"\" src=\"/static/f20eb0f9/images/16x16/health-00to19.png\" /></td><td>Build stability: All recent builds failed.</td><td align=\"right\">0</td></tr></tbody></table></div></td><td><a class=\"model-link inside\" href=\"job/KevoreeWeb%20Compile/\">\n" +
            "  KevoreeWeb Compile\n" +
            "</a></td><td data=\"-\">N/A</td><td data=\"2013-07-16T07:05:20Z\">\n" +
            "        6 days 1 hr\n" +
            "        - <a class=\"model-link inside\" href=\"job/KevoreeWeb%20Compile/lastFailedBuild/\">#4</a></td><td data=\"53927\">53 sec</td><td></td><td> </td></tr><tr id=\"job_KMF\"><td data=\"4\"><img alt=\"Success\" class=\"icon32x32\" src=\"/static/f20eb0f9/images/32x32/blue.png\" tooltip=\"Success\" /></td><td data=\"100\" class=\"healthReport\" onmouseover=\"this.className='healthReport hover';return true;\n" +
            "        \" onmouseout=\"this.className='healthReport';return true;\"><a href=\"job/KMF/lastBuild\"><img alt=\"100%\" class=\"icon32x32\" src=\"/static/f20eb0f9/images/32x32/health-80plus.png\" /></a><div class=\"healthReportDetails\"><table border=\"0\"><thead><tr><th align=\"left\">W</th><th align=\"left\">Description</th><th align=\"right\">%</th></tr></thead><tbody><tr><td align=\"left\"><img title=\"\" alt=\"\" src=\"/static/f20eb0f9/images/16x16/health-80plus.png\" /></td><td>Test Result: 0 tests failing out of a total of 6 tests.</td><td align=\"right\">100</td></tr><tr><td align=\"left\"><img title=\"\" alt=\"\" src=\"/static/f20eb0f9/images/16x16/health-80plus.png\" /></td><td>Build stability: No recent builds failed.</td><td align=\"right\">100</td></tr></tbody></table></div></td><td><a class=\"model-link inside\" href=\"job/KMF/\">\n" +
            "  KMF\n" +
            "</a></td><td data=\"2013-07-21T23:21:44Z\">\n" +
            "        9 hr 38 min\n" +
            "        - <a class=\"model-link inside\" href=\"job/KMF/lastSuccessfulBuild/\">#11</a></td><td data=\"2013-07-16T23:20:20Z\">\n" +
            "        5 days 9 hr\n" +
            "        - <a class=\"model-link inside\" href=\"job/KMF/lastFailedBuild/\">#5</a></td><td data=\"388708\">6 min 28 sec</td><td><a href=\"job/KMF/build?delay=0sec\"><img title=\"Schedule a build\" alt=\"Schedule a build\" onclick=\"return build_id596013(this)\" src=\"/static/f20eb0f9/images/24x24/clock.png\" border=\"0\" /></a><script>function build_id596013(img) {\n" +
            "                  new Ajax.Request(img.parentNode.href);\n" +
            "                  hoverNotification('Build scheduled', img, -100);\n" +
            "                  return false;\n" +
            "                }</script></td><td> </td></tr><tr id=\"job_KMF Samples\"><td data=\"4\"><img alt=\"Success\" class=\"icon32x32\" src=\"/static/f20eb0f9/images/32x32/blue.png\" tooltip=\"Success\" /></td><td data=\"100\" class=\"healthReport\" onmouseover=\"this.className='healthReport hover';return true;\n" +
            "        \" onmouseout=\"this.className='healthReport';return true;\"><a href=\"job/KMF%20Samples/lastBuild\"><img alt=\"100%\" class=\"icon32x32\" src=\"/static/f20eb0f9/images/32x32/health-80plus.png\" /></a><div class=\"healthReportDetails\"><table border=\"0\"><thead><tr><th align=\"left\">W</th><th align=\"left\">Description</th><th align=\"right\">%</th></tr></thead><tbody><tr><td align=\"left\"><img title=\"\" alt=\"\" src=\"/static/f20eb0f9/images/16x16/health-80plus.png\" /></td><td>Test Result: 0 tests failing out of a total of 14 tests.</td><td align=\"right\">100</td></tr><tr><td align=\"left\"><img title=\"\" alt=\"\" src=\"/static/f20eb0f9/images/16x16/health-80plus.png\" /></td><td>Build stability: No recent builds failed.</td><td align=\"right\">100</td></tr></tbody></table></div></td><td><a class=\"model-link inside\" href=\"job/KMF%20Samples/\">\n" +
            "  KMF Samples\n" +
            "</a></td><td data=\"2013-07-22T08:14:44Z\">\n" +
            "        45 min\n" +
            "        - <a class=\"model-link inside\" href=\"job/KMF%20Samples/lastSuccessfulBuild/\">#10</a></td><td data=\"-\">N/A</td><td data=\"2062799\">34 min</td><td><a href=\"job/KMF%20Samples/build?delay=0sec\"><img title=\"Schedule a build\" alt=\"Schedule a build\" onclick=\"return build_id596014(this)\" src=\"/static/f20eb0f9/images/24x24/clock.png\" border=\"0\" /></a><script>function build_id596014(img) {\n" +
            "                  new Ajax.Request(img.parentNode.href);\n" +
            "                  hoverNotification('Build scheduled', img, -100);\n" +
            "                  return false;\n" +
            "                }</script></td><td> </td></tr><tr id=\"job_WebSite restart\" class=\"disabledJob\"><td data=\"8\"><img alt=\"Disabled\" class=\"icon32x32\" src=\"/static/f20eb0f9/images/32x32/grey.png\" tooltip=\"Disabled\" /></td><td data=\"100\" class=\"healthReport\" onmouseover=\"this.className='healthReport hover';return true;\n" +
            "        \" onmouseout=\"this.className='healthReport';return true;\"><img alt=\"100%\" class=\"icon32x32\" src=\"/static/f20eb0f9/images/32x32/empty.png\" /></td><td><a class=\"model-link inside\" href=\"job/WebSite%20restart/\">\n" +
            "  WebSite restart\n" +
            "</a></td><td data=\"-\">N/A</td><td data=\"-\">N/A</td><td data=\"0\">N/A</td><td></td><td> </td></tr><tr id=\"job_WebSite tester\" class=\"disabledJob\"><td data=\"8\"><img alt=\"Disabled\" class=\"icon32x32\" src=\"/static/f20eb0f9/images/32x32/grey.png\" tooltip=\"Disabled\" /></td><td data=\"100\" class=\"healthReport\" onmouseover=\"this.className='healthReport hover';return true;\n" +
            "        \" onmouseout=\"this.className='healthReport';return true;\"><a href=\"job/WebSite%20tester/lastBuild\"><img alt=\"100%\" class=\"icon32x32\" src=\"/static/f20eb0f9/images/32x32/health-80plus.png\" /></a><div class=\"healthReportDetails\"><table border=\"0\"><thead><tr><th align=\"left\">W</th><th align=\"left\">Description</th><th align=\"right\">%</th></tr></thead><tbody><tr><td align=\"left\"><img title=\"\" alt=\"\" src=\"/static/f20eb0f9/images/16x16/health-80plus.png\" /></td><td>Build stability: No recent builds failed.</td><td align=\"right\">100</td></tr></tbody></table></div></td><td><a class=\"model-link inside\" href=\"job/WebSite%20tester/\">\n" +
            "  WebSite tester\n" +
            "</a></td><td data=\"2013-07-16T08:51:20Z\">\n" +
            "        6 days 0 hr\n" +
            "        - <a class=\"model-link inside\" href=\"job/WebSite%20tester/lastSuccessfulBuild/\">#499</a></td><td data=\"-\">N/A</td><td data=\"389\">0.38 sec</td><td></td><td> </td></tr><tr id=\"job_WebSiteTest restart\" class=\"disabledJob\"><td data=\"8\"><img alt=\"Disabled\" class=\"icon32x32\" src=\"/static/f20eb0f9/images/32x32/grey.png\" tooltip=\"Disabled\" /></td><td data=\"100\" class=\"healthReport\" onmouseover=\"this.className='healthReport hover';return true;\n" +
            "        \" onmouseout=\"this.className='healthReport';return true;\"><img alt=\"100%\" class=\"icon32x32\" src=\"/static/f20eb0f9/images/32x32/empty.png\" /></td><td><a class=\"model-link inside\" href=\"job/WebSiteTest%20restart/\">\n" +
            "  WebSiteTest restart\n" +
            "</a></td><td data=\"-\">N/A</td><td data=\"-\">N/A</td><td data=\"0\">N/A</td><td></td><td> </td></tr><tr id=\"job_WebSiteTest tester\" class=\"disabledJob\"><td data=\"8\"><img alt=\"Disabled\" class=\"icon32x32\" src=\"/static/f20eb0f9/images/32x32/grey.png\" tooltip=\"Disabled\" /></td><td data=\"100\" class=\"healthReport\" onmouseover=\"this.className='healthReport hover';return true;\n" +
            "        \" onmouseout=\"this.className='healthReport';return true;\"><img alt=\"100%\" class=\"icon32x32\" src=\"/static/f20eb0f9/images/32x32/empty.png\" /></td><td><a class=\"model-link inside\" href=\"job/WebSiteTest%20tester/\">\n" +
            "  WebSiteTest tester\n" +
            "</a></td><td data=\"-\">N/A</td><td data=\"-\">N/A</td><td data=\"0\">N/A</td><td></td><td> </td></tr></table><table style=\"width:100%\"><tr><td>Icon:\n" +
            "         <a href=\"/iconSize?16x16\">S</a> <a href=\"/iconSize?24x24\">M</a> L</td><td><div align=\"right\" style=\"margin:1em\"><a href=\"/legend\">Legend</a><span style=\"padding-left:1em\"><a href=\"rssAll\"><img height=\"16\" alt=\"Feed\" width=\"16\" src=\"/static/f20eb0f9/images/atom.gif\" border=\"0\" /> RSS for all</a></span><span style=\"padding-left:1em\"><a href=\"rssFailed\"><img height=\"16\" alt=\"Feed\" width=\"16\" src=\"/static/f20eb0f9/images/atom.gif\" border=\"0\" /> RSS for failures</a></span><span style=\"padding-left:1em\"><a href=\"rssLatest\"><img height=\"16\" alt=\"Feed\" width=\"16\" src=\"/static/f20eb0f9/images/atom.gif\" border=\"0\" /> RSS for just latest builds</a></span></div></td></tr></table></div></td></tr></table><table width=\"100%\"><tr><td id=\"footer\"><span style=\"padding-right:2em; color:gray\">\n" +
            "          Page generated:\n" +
            "          Jul 22, 2013 9:00:37 AM</span><span style=\"padding-right:2em\"><a href=\"api/\">REST API</a></span><a href=\"http://jenkins-ci.org/\">Jenkins ver. 1.523</a></td></tr></table><script>Behaviour.addLoadEvent(function() {\n" +
            "            downloadService.download(\n" +
            "                \"default\",\n" +
            "                \"http://updates.jenkins-ci.org/update-center.json\",\n" +
            "                {version:\"1.523\"},\n" +
            "                \"/updateCenter/byId/default/postBack\",\n" +
            "                null);\n" +
            "        });</script><script>Behaviour.addLoadEvent(function() {  downloadService.download(\"hudson.tasks.Maven.MavenInstaller\",\"http://updates.jenkins-ci.org/updates/hudson.tasks.Maven.MavenInstaller.json\",{version:\"1.523\"},\"/descriptor/hudson.model.DownloadService/byId/hudson.tasks.Maven.MavenInstaller/postBack\",null);});</script><script>Behaviour.addLoadEvent(function() {  downloadService.download(\"hudson.tasks.Ant.AntInstaller\",\"http://updates.jenkins-ci.org/updates/hudson.tasks.Ant.AntInstaller.json\",{version:\"1.523\"},\"/descriptor/hudson.model.DownloadService/byId/hudson.tasks.Ant.AntInstaller/postBack\",null);});</script><script>Behaviour.addLoadEvent(function() {  downloadService.download(\"hudson.tools.JDKInstaller\",\"http://updates.jenkins-ci.org/updates/hudson.tools.JDKInstaller.json\",{version:\"1.523\"},\"/descriptor/hudson.model.DownloadService/byId/hudson.tools.JDKInstaller/postBack\",null);});</script><div id=\"l10n-dialog\" class=\"dialog\"></div><div id=\"l10n-footer\" style=\"display:none; float:left\"><a href=\"#\" onclick=\"return showTranslationDialog();\"><img src=\"/static/f20eb0f9/plugin/translation/flags.png\" />\n" +
            "      Help us localize this page\n" +
            "    </a></div><script>var footer = document.getElementById('l10n-footer');\n" +
            "    var f = document.getElementById('footer');\n" +
            "    f.insertBefore(footer,f.firstChild);\n" +
            "    footer.style.display=\"block\";\n" +
            "\n" +
            "    var translation={}; \n" +
            "    translation.bundles = \"7lI+s7tm7b2LeGHUDv10epyETldKadyOkLLJgeiO/MZaueNE+p913WxIAroawUohDOWcI9SHsEUYJcgnIV3bRgk93eWticf5SCQ+jp/+SZJgS9KXVWZ6oEi7Gv7M7c81w/zg8A8ilE4AQ12Z5iOBfxGvBJw3a6dT8K2FmdBvm2Jgx1/0jy3fF32RycpyOWqKc2tGor3jmHbbn6SrqxrLtxXTHZasHrRmoHheexI09inJ+fy0j7B2kvx8D8CLwH9stdKxQvsqSnmdy4FQ9mBeOZPBYmHUv8zG9VTJbW5fs4MMhzR4dWHH1Oeack29H7BKwXrIQqAo0Oq/58L5m74nelFUwsmvdv6jTXUjjCMKDdaO5B04wfoNCKMqupmUTl1EOqICdf3qeGD19ItopWilY/Ln1jKQHBPTM1QLq7nR13dMkol4vZE5LYmxyAfqOacnEgEaLa64WWt140WbuSs0+cISmNG1ChBmZ0xBeqWZHBSaVUBIYBB1Q51sgY3gIS1KPehCXhEZuGfYgVyaoH0L9iBgsd5cw2dfCJdnLR8Gx+js+vz7qsc6OQ3PWwJDO2owOSmxn8sgkWUjj/vzIHNBFIvBxL9Nw1sSz0KTqbv+DbesoDeU2LWqlwPzif6PocVGm4RV+4rITz60TPFNSYcdA2oWumOMkz6B+CUozOXAmSnCgae7z3Y/lQjJ/QI1k/iSYwtJ/ALThwAe5pnMBtw3J6ycPl8ByO8+/2oNdTkziGVsHXF9zp2SLbOwHV0/H/ijGY9qBqrtj20updy2dbuLwZaOgKyRi25X+gNcd1rJZklGJ1b/iTzZ8IZOjML4vkPZiWfY/2UEwAE79ruuRdSA6w==\";\n" +
            "    translation.detectedLocale = \"\";\n" +
            "\n" +
            "    function showTranslationDialog() {\n" +
            "      if(!translation.launchDialog)\n" +
            "        loadScript(\"/static/f20eb0f9/plugin/translation/dialog.js\");\n" +
            "      else\n" +
            "        translation.launchDialog();\n" +
            "      return false; \n" +
            "    }</script></body></html>";

    private static HttpServer server;

    @BeforeClass
    public static void before() {
        try {
            InetSocketAddress addr = new InetSocketAddress(8080);
            server = HttpServer.create(addr, 0);

            server.createContext("/", new HttpHandler() {
                public void handle(HttpExchange exchange) throws IOException {
                    String requestMethod = exchange.getRequestMethod();
                    if (requestMethod.equalsIgnoreCase("GET")) {
                        Headers responseHeaders = exchange.getResponseHeaders();
                        responseHeaders.set("Content-Type", "text/plain");
                        exchange.sendResponseHeaders(200, 0);

                        OutputStream responseBody = exchange.getResponseBody();
                        /*Headers requestHeaders = exchange.getRequestHeaders();
                        Set<String> keySet = requestHeaders.keySet();
                        for (String key : keySet) {
                            List values = requestHeaders.get(key);
                            String s = key + " = " + values.toString() + "\n";
                            responseBody.write(s.getBytes());
                        }
                        responseBody.write(exchange.getClass().getName().getBytes());*/
                        responseBody.write(webContent.getBytes("UTF-8"));
                        responseBody.close();
                    }
                }
            });
            server.setExecutor(Executors.newCachedThreadPool());
            server.start();
            System.out.println("Server is listening on port 8080");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void after() {
        server.stop(1000);
    }

    @Test
    public void testNoContractViolation() {
        EnumSet<Metric> reason =  EnumSet.noneOf(Metric.class);
        reason.add(Metric.NetworkR);

        double maxValue1 = 100000.0;
        MonitoringNotification notification = new MonitoringNotification(false, reason);
        String monitoringRegex = notification.toRegex();
        ContractViolationEvent violation = new ContractViolationEvent("nodes[node0]/components[networkComponent]", Metric.NetworkR, -1.0, maxValue1);
        String violationRegex = violation.toRegex();
        String result = runSandbox("network/network-sample-input-peak-second-good.kevs", 20000, Arrays.asList(monitoringRegex, violationRegex));
        Assert.assertEquals(true, "".equals(result) || result == null);
    }

    @Test
    public void testContractViolation() {
        EnumSet<Metric> reason =  EnumSet.noneOf(Metric.class);
        reason.add(Metric.NetworkR);
        double maxValue1 = 10000.0;
        MonitoringNotification notification = new MonitoringNotification(false, reason);
        String monitoringRegex = notification.toRegex();
        ContractViolationEvent violation = new ContractViolationEvent("nodes[node0]/components[networkComponent]", Metric.NetworkR, -1.0, maxValue1);
        String violationRegex = violation.toRegex();

        String result = runSandbox("network/network-sample-input-peak-second-fail.kevs", 200000, Arrays.asList(monitoringRegex, violationRegex));

        Assert.assertEquals(true, result.contains(notification.toString()));

        String[] resultsArray = result.split("\n");
        Pattern pattern = Pattern.compile(violationRegex);
        Matcher m = pattern.matcher(resultsArray[1]);
        if (m.find()) {
            double value = Double.parseDouble(m.group(1));
            Assert.assertEquals(true, value > maxValue1);
        }
    }
}
