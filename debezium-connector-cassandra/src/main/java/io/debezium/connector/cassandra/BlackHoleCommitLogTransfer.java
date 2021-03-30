/*
 * Copyright Debezium Authors.
 *
 * Licensed under the Apache Software License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package io.debezium.connector.cassandra;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementation of {@link CommitLogTransfer} which deletes commit logs.
 */
public class BlackHoleCommitLogTransfer implements CommitLogTransfer {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlackHoleCommitLogTransfer.class);

    @Override
    public void onSuccessTransfer(File file) {
        LOGGER.debug("INSTA: deleting commitlog after successful transfer");
        CommitLogUtil.deleteCommitLog(file);
    }

    @Override
    public void onErrorTransfer(File file) {
        LOGGER.debug("INSTA: deleting commitlog after unsuccessful transfer");
        CommitLogUtil.deleteCommitLog(file);
    }

    @Override
    public void getErrorCommitLogFiles() {
    }
}
