SUMMARY = "A library implementing the EBU R128 loudness standard"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=b7edcc6cb01ace25ebd2555cf15473dc"

SRC_URI = "git://github.com/jiixyj/libebur128.git;branch=master;protocol=https"
SRCREV = "67b33abe1558160ed76ada1322329b0e9e058b02"
PV = "1.2.6"
S = "${WORKDIR}/git"

inherit cmake
