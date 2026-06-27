#!/usr/bin/env bash
if ! [[ -d .postgres ]]; then
  mkdir -p .postgres
  initdb -D .postgres
fi
postgres -k . -D .postgres