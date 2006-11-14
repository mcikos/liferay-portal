/**
 * Copyright (c) 2000-2006 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.liferay.portlet.wiki.service.spring;

/**
 * <a href="WikiPageLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * @author  Brian Wing Shun Chan
 *
 */
public interface WikiPageLocalService {
	public com.liferay.portlet.wiki.model.WikiPage addPage(
		java.lang.String userId, java.lang.String nodeId, java.lang.String title)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException;

	public void addPageResources(java.lang.String nodeId,
		java.lang.String title, boolean addCommunityPermissions,
		boolean addGuestPermissions)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException;

	public void addPageResources(com.liferay.portlet.wiki.model.WikiNode node,
		com.liferay.portlet.wiki.model.WikiPage page,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException;

	public void addPageResources(java.lang.String nodeId,
		java.lang.String title, java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException;

	public void addPageResources(com.liferay.portlet.wiki.model.WikiNode node,
		com.liferay.portlet.wiki.model.WikiPage page,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException;

	public void deletePage(java.lang.String nodeId, java.lang.String title)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException;

	public void deletePage(com.liferay.portlet.wiki.model.WikiPage page)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException;

	public void deletePages(java.lang.String nodeId)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException;

	public java.util.List getLinks(java.lang.String nodeId,
		java.lang.String title) throws com.liferay.portal.SystemException;

	public java.util.List getOrphans(java.lang.String nodeId)
		throws com.liferay.portal.SystemException;

	public com.liferay.portlet.wiki.model.WikiPage getPage(
		java.lang.String nodeId, java.lang.String title)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException;

	public com.liferay.portlet.wiki.model.WikiPage getPage(
		java.lang.String nodeId, java.lang.String title, double version)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException;

	public java.util.List getPages(java.lang.String nodeId, int begin, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List getPages(java.lang.String nodeId,
		java.lang.String title, int begin, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List getPages(java.lang.String nodeId, boolean head,
		int begin, int end) throws com.liferay.portal.SystemException;

	public java.util.List getPages(java.lang.String nodeId,
		java.lang.String title, boolean head, int begin, int end)
		throws com.liferay.portal.SystemException;

	public int getPagesCount(java.lang.String nodeId)
		throws com.liferay.portal.SystemException;

	public int getPagesCount(java.lang.String nodeId, java.lang.String title)
		throws com.liferay.portal.SystemException;

	public int getPagesCount(java.lang.String nodeId, boolean head)
		throws com.liferay.portal.SystemException;

	public int getPagesCount(java.lang.String nodeId, java.lang.String title,
		boolean head) throws com.liferay.portal.SystemException;

	public java.util.List getRecentChanges(java.lang.String nodeId, int begin,
		int end) throws com.liferay.portal.SystemException;

	public int getRecentChangesCount(java.lang.String nodeId)
		throws com.liferay.portal.SystemException;

	public com.liferay.portlet.wiki.model.WikiPage revertPage(
		java.lang.String userId, java.lang.String nodeId,
		java.lang.String title, double version)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException;

	public com.liferay.portlet.wiki.model.WikiPage updatePage(
		java.lang.String userId, java.lang.String nodeId,
		java.lang.String title, java.lang.String content,
		java.lang.String format)
		throws com.liferay.portal.PortalException, 
			com.liferay.portal.SystemException;
}