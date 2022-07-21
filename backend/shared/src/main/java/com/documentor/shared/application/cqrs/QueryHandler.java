package com.documentor.shared.application.cqrs;

import an.awesome.pipelinr.Command;

public interface QueryHandler<C extends Query<R>, R> extends Command.Handler<C, R> {
}
