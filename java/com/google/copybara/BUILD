# Copyright 2016 Google Inc.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

licenses(["notice"])  # Apache 2.0

package(default_visibility = ["//visibility:public"])

load(":docs.bzl", "doc_generator")

exports_files(
    [
        "doc_skylark.sh",
        "docs.bzl",
    ],
    visibility = ["//visibility:public"],
)

JAVACOPTS = [
    "-Xlint:unchecked",
    "-source",
    "1.8",
]

java_binary(
    name = "copybara",
    javacopts = JAVACOPTS,
    main_class = "com.google.copybara.Main",
    runtime_deps = [
        ":copybara_main",
    ],
)

java_library(
    name = "copybara_main",
    srcs = ["Main.java"],
    javacopts = JAVACOPTS,
    deps = [
        ":base",
        ":copybara_lib",
        ":general_options",
        "//java/com/google/copybara/config:base",
        "//java/com/google/copybara/exception",
        "//java/com/google/copybara/jcommander:converters",
        "//java/com/google/copybara/profiler",
        "//java/com/google/copybara/util",
        "//java/com/google/copybara/util/console",
        "//third_party:flogger",
        "//third_party:guava",
        "//third_party:jcommander",
        "//third_party:jsr305",
        "//third_party:skylark-lang",
    ],
)

doc_generator(
    name = "docs",
    deps = [":copybara"],
)

BASE_SRCS = [
    "BaselinesWithoutLabelVisitor.java",
    "Change.java",
    "ChangeMessage.java",
    "Changes.java",
    "ChangeVisitable.java",
    "CheckoutPath.java",
    "CheckoutPathAttributes.java",
    "ConfigItemDescription.java",
    "Destination.java",
    "DestinationEffect.java",
    "DestinationReader.java",
    "DestinationStatusVisitor.java",
    "Endpoint.java",
    "EndpointProvider.java",
    "Info.java",
    "LazyResourceLoader.java",
    "LabelFinder.java",
    "LocalParallelizer.java",
    "Metadata.java",
    "MigrationInfo.java",
    "NonReversibleValidationException.java",
    "Option.java",
    "Options.java",
    "Origin.java",
    "Revision.java",
    "SkylarkContext.java",
    "Transformation.java",
    "TransformResult.java",
    "TransformWork.java",
    "Trigger.java",
    "treestate/FileSystemTreeState.java",
    "treestate/MapBasedTreeState.java",
    "treestate/TreeState.java",
    "treestate/TreeStateUtil.java",
    "WorkflowOptions.java",
    "WriterContext.java",
]

java_library(
    name = "options",
    srcs = [
        "Option.java",
        "Options.java",
    ],
    javacopts = JAVACOPTS,
    deps = [
        "//third_party:guava",
        "//third_party:jsr305",
        "//third_party:re2j",
        "//third_party:shell",
    ],
)

java_library(
    name = "moduleset",
    srcs = ["ModuleSet.java"],
    javacopts = JAVACOPTS,
    deps = [
        ":options",
        "//third_party:guava",
    ],
)

java_library(
    name = "base",
    srcs = BASE_SRCS,
    javacopts = JAVACOPTS,
    deps = [
        "//java/com/google/copybara/authoring",
        "//java/com/google/copybara/doc:annotations",
        "//java/com/google/copybara/exception",
        "//java/com/google/copybara/jcommander:converters",
        "//java/com/google/copybara/jcommander:validators",
        "//java/com/google/copybara/util",
        "//java/com/google/copybara/util/console",
        "//third_party:autovalue",
        "//third_party:flogger",
        "//third_party:guava",
        "//third_party:jcommander",
        "//third_party:jsr305",
        "//third_party:re2j",
        "//third_party:skylark-lang",
    ],
)

java_library(
    name = "general_options",
    srcs = ["GeneralOptions.java"],
    javacopts = JAVACOPTS,
    deps = [
        ":base",
        "//java/com/google/copybara/exception",
        "//java/com/google/copybara/jcommander:converters",
        "//java/com/google/copybara/monitor",
        "//java/com/google/copybara/profiler",
        "//java/com/google/copybara/util",
        "//java/com/google/copybara/util/console",
        "//third_party:autovalue",
        "//third_party:flogger",
        "//third_party:guava",
        "//third_party:jcommander",
        "//third_party:jsr305",
        "//third_party:re2j",
        "//third_party:skylark-lang",
    ],
)

java_library(
    name = "copybara_lib",
    srcs = glob(
        ["**/*.java"],
        exclude = [
            "Main.java",
            "GeneralOptions.java",
        ] + BASE_SRCS,
    ),
    javacopts = JAVACOPTS,
    deps = [
        ":base",
        ":general_options",
        "//java/com/google/copybara/authoring",
        "//java/com/google/copybara/config:base",
        "//java/com/google/copybara/config:global_migrations",
        "//java/com/google/copybara/config:parser",
        "//java/com/google/copybara/doc:annotations",
        "//java/com/google/copybara/exception",
        "//java/com/google/copybara/git",
        "//java/com/google/copybara/hg",
        "//java/com/google/copybara/monitor",
        "//java/com/google/copybara/profiler",
        "//java/com/google/copybara/remotefile",
        "//java/com/google/copybara/templatetoken",
        "//java/com/google/copybara/transform",
        "//java/com/google/copybara/transform/debug",
        "//java/com/google/copybara/transform/patch",
        "//java/com/google/copybara/util",
        "//java/com/google/copybara/util/console",
        "//third_party:flogger",
        "//third_party:guava",
        "//third_party:jcommander",
        "//third_party:jsr305",
        "//third_party:re2j",
        "//third_party:skylark-lang",
    ],
)
