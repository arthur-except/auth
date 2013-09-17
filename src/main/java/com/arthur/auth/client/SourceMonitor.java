package com.arthur.auth.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * Resource monitor<br>
 * 
 * @author Arthur
 * 
 */
@Component
public class SourceMonitor implements InitializingBean {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(SourceMonitor.class);

	@Autowired
	@Qualifier("urlSourceBuilder")
	private UrlSourceBuilder urlSourceBuilder;

	@Autowired
	@Qualifier("methodSourceBuilder")
	private MethodSourceBuilder methodSourceBuilder;

	public void afterPropertiesSet() throws Exception {
		Assert.notNull(urlSourceBuilder, "urlSourceBuilder mustn't be null");
		Assert.notNull(methodSourceBuilder,
				"methodSourceBuilder mustn't be null");
	}

	public void refresh() {
		long start = System.currentTimeMillis();
		LOGGER.debug("Begin to refresh security resources...");

		if (null != urlSourceBuilder) {
			urlSourceBuilder.refresh();
		}
		if (null != methodSourceBuilder) {
			methodSourceBuilder.refresh();
		}
		LOGGER.debug("complete refresh resource consuming {}ms",
				System.currentTimeMillis() - start);
	}

}
