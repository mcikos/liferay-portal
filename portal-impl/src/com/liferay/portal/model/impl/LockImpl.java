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

package com.liferay.portal.model.impl;

/**
 * @author Brian Wing Shun Chan
 */
public class LockImpl extends LockBaseImpl {

	public LockImpl() {
	}

	public long getExpirationTime() {
		if (isNeverExpires()) {
			return 0;
		}
		else {
			return getExpirationDate().getTime() - getCreateDate().getTime();
		}
	}

	public boolean isExpired() {
		if (isNeverExpires()) {
			return false;
		}
		else if (System.currentTimeMillis() > getExpirationDate().getTime()) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isNeverExpires() {
		if (getExpirationDate() == null) {
			return true;
		}
		else {
			return false;
		}
	}

}