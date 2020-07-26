SUMMARY = "Redkite is a small free software GUI toolkit"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84216b5b30fa50e81f28b8f28feb2e10"

DEPENDS = "cairo"

inherit cmake features_check

REQUIRED_DISTRO_FEATURES = "x11"

SRC_URI = "git://github.com/iurie-sw/redkite.git"
SRCREV = "8c8241b464d0adc3db56d7c69247211eec2bc076"
PV = "1.0.1"
S = "${WORKDIR}/git"

BBCLASSEXTEND = "native"
