SUMMARY = "A Spotify daemon"
HOMEPAGE = "https://github.com/Spotifyd/spotifyd"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

DEPENDS = " \
    alsa-lib \
    libogg \
    openssl \
    dbus \
"

inherit cargo-fetch

SRC_URI = " \
    git://github.com/Spotifyd/spotifyd.git \
"

SRCREV = "27ce5ac95c3a9b8de84bc4c0969a942fda2e2ad0"
S = "${WORKDIR}/git"
# crate ruins SRCPV so set PV manually
#PV = "0.2.24+git133a1199"

PV = "0.3.0"

# No unconditional start on each boot
#do_install_append() {
#    install -d ${D}${systemd_user_unitdir}
#    install -m 644 ${S}/contrib/spotifyd.service ${D}${systemd_user_unitdir}
#}

PACKAGECONFIG ??= "${@bb.utils.filter('DISTRO_FEATURES', 'pulseaudio', d)}"
PACKAGECONFIG[pulseaudio] = ",,pulseaudio"
PACKAGECONFIG[portaudio] = ",,portaudio"

#CARGO_BUILD_FLAGS += "--features dbus_mpris,dbus_keyring,alsa_backend${@bb.utils.contains('PACKAGECONFIG', 'pulseaudio', ',pulseaudio_backend', '', d)}${@bb.utils.contains('PACKAGECONFIG', 'portaudio', ',portaudio_backend', '', d)}"

FILES_${PN} += "${systemd_user_unitdir}"
