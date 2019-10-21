SUMMARY = "Qt based sequencer"
HOMEPAGE = "https://lmms.io"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=751419260aa954499f7abaabaa882bbe"

SRC_URI = "gitsm://github.com/LMMS/${BPN}.git;branch=stable-1.2"
SRCREV = "dbf5f47149fbb7584bf48ce9e767b9e90ee2df7e"
S = "${WORKDIR}/git"
PV = "1.2.1+git${SRCPV}"
