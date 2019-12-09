SUMMARY = "Ganv is a Gtk widget for interactive graph-like environments"
DESCRIPTION = "Ganv is a Gtk widget for interactive graph-like environments, such as modular synthesizers or finite state machines"
HOMEPAGE = "http://drobilla.net/software/ganv"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

inherit waf

DEPENDS += " \
    glib-2.0-native \
    gtk+ \
    gtkmm \
"

SRC_URI = " \
    git://git.drobilla.net/ganv.git \
    file://0001-Fix-build-for-python3-only-environments.patch \
"
SRCREV = "87bd186ede49ae3a7e8402b148f1bd26344ce4db"
S = "${WORKDIR}/git"
PV = "1.5.4+git${SRCPV}"
