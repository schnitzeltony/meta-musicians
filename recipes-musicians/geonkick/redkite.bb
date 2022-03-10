SUMMARY = "Redkite is a small free software GUI toolkit"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84216b5b30fa50e81f28b8f28feb2e10"

DEPENDS = "cairo"

inherit cmake features_check

REQUIRED_DISTRO_FEATURES = "x11"

SRC_URI = "git://github.com/iurie-sw/redkite.git;branch=master;protocol=https"
SRCREV = "5ff4841320716e93a27b5be7c8557df8b333492a"
PV = "1.3.1"
S = "${WORKDIR}/git"

BBCLASSEXTEND = "native"
