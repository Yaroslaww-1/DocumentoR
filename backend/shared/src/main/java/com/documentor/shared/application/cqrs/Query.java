package com.documentor.shared.application.cqrs;

import an.awesome.pipelinr.Command;

public interface Query<R> extends Command<R> {
}
