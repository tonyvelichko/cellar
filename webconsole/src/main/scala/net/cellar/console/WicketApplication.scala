/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.cellar.console

import org.apache.wicket.protocol.http.WebApplication
import org.osgi.framework.{BundleContext, BundleActivator}
import org.apache.wicket.request.target.coding.MixedParamUrlCodingStrategy
import pages.{NodeDetailsPage, HandlersPage, NodesPage, HomePage}

/**
 * @author iocanel
 */

class WicketApplication extends WebApplication with BundleActivator {

  def getHomePage = classOf[HomePage]

  //Mount Bookmarkable Pages
  mountBookmarkablePage("home", classOf[HomePage])
  mountBookmarkablePage("nodes", classOf[NodesPage])
  mountBookmarkablePage("handlers", classOf[HandlersPage])

  var nodeDetailsURLs = new MixedParamUrlCodingStrategy("node", classOf[NodeDetailsPage], Array {
    "id"
  })

  mount(nodeDetailsURLs)

  def stop(context: BundleContext) {
    WicketApplication.bundleContext = context
  }

  def start(context: BundleContext) {
    WicketApplication.bundleContext = context
  }
}

object WicketApplication {
  var bundleContext: BundleContext = _
}
