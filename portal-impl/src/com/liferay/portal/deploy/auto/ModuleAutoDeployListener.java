/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.deploy.auto;

import aQute.lib.osgi.Constants;

import aQute.libg.header.OSGiHeader;

import com.liferay.portal.kernel.deploy.auto.AutoDeployException;
import com.liferay.portal.kernel.deploy.auto.BaseAutoDeployListener;
import com.liferay.portal.kernel.deploy.auto.context.AutoDeploymentContext;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.jar.Attributes;
import java.util.jar.JarInputStream;
import java.util.jar.Manifest;

/**
 * @author Miguel Pastor
 */
public class ModuleAutoDeployListener extends BaseAutoDeployListener {

	public ModuleAutoDeployListener() {
		_autoDeployer = new ThreadSafeAutoDeployer(new ModuleAutoDeployer());
	}

	public void deploy(AutoDeploymentContext autoDeploymentContext)
		throws AutoDeployException {

		File file = autoDeploymentContext.getFile();

		if (_log.isDebugEnabled()) {
			_log.debug("Invoking deploy for " + file.getPath());
		}

		if (!isModule(file)) {
			return;
		}

		if (_log.isInfoEnabled()) {
			_log.info("Copied module for " + file.getPath());
		}

		int code = _autoDeployer.autoDeploy(autoDeploymentContext);

		if ((code == AutoDeployer.CODE_DEFAULT) && _log.isInfoEnabled()) {
			_log.info(
				"Module for " + file.getPath() + " copied successfully. " +
					"Deployment will start in a few seconds.");
		}
	}

	protected boolean isModule(File file) throws AutoDeployException {
		if (!isJarFile(file)) {
			return false;
		}

		Manifest manifest = null;

		try {
			JarInputStream jarInputStream = new JarInputStream(
				new FileInputStream(file));

			manifest = jarInputStream.getManifest();
		}
		catch (IOException ioe) {
			throw new AutoDeployException(ioe);
		}

		if (manifest == null) {
			return false;
		}

		Attributes attributes = manifest.getMainAttributes();

		String bundleSymbolicNameAttributeValue = attributes.getValue(
			Constants.BUNDLE_SYMBOLICNAME);

		Map<String, Map<String, String>> bundleSymbolicNameMap =
			OSGiHeader.parseHeader(bundleSymbolicNameAttributeValue);

		Set<String> bundleSymbolicNameSet = bundleSymbolicNameMap.keySet();

		if (bundleSymbolicNameSet.isEmpty()) {
			return false;
		}

		Iterator<String> bundleSymbolicNameIterator =
			bundleSymbolicNameSet.iterator();

		String bundleSymbolicName = bundleSymbolicNameIterator.next();

		return Validator.isNotNull(bundleSymbolicName);
	}

	private static Log _log = LogFactoryUtil.getLog(
		ModuleAutoDeployListener.class);

	private AutoDeployer _autoDeployer;

}